package com.example.quality_inventory.service;

import com.example.quality_inventory.InspectionResult;
import com.example.quality_inventory.client.EmployeeCustomerClient;
import com.example.quality_inventory.client.NotificationClient;
import com.example.quality_inventory.client.ProductionClient;
import com.example.quality_inventory.dto.NotificationDto;
import com.example.quality_inventory.dto.QualityInspectionDto;
import com.example.quality_inventory.entity.QualityInspection;
import com.example.quality_inventory.repository.QualityInspectionRepository;
import com.example.quality_inventory.util.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class QualityInspectionServiceImp implements QualityInspectionService {
      private final QualityInspectionRepository qualityInspectionRepository;
      private final QualityInspectionMapper qualityInspectionMapper;
    private final ProductionClient productionClient;
    private final EmployeeCustomerClient employeeCustomerClient;
    private final NotificationClient notificationClient;
    @Override
    public QualityInspectionDto createQualityInspectionDto(QualityInspectionDto qualityInspectionDto) {
        Boolean productionExist=productionClient.checkOrderExists(qualityInspectionDto.getProductionOrder()).getBody();
        if (Boolean.FALSE.equals(productionExist)) {
            throw new EntityNotFoundException("Production Order not found with id : " + qualityInspectionDto.getProductionOrder());
        }
        Boolean employeeExist=employeeCustomerClient.checkEmployeeExists(qualityInspectionDto.getInspector()).getBody();
        if (Boolean.FALSE.equals(employeeExist)) {
            throw new EntityNotFoundException("Production Order not found with id : " + qualityInspectionDto.getInspector());
        }

        QualityInspection entity = qualityInspectionMapper.toEntity(qualityInspectionDto);
        QualityInspection savedEntity = qualityInspectionRepository.save(entity);
        return qualityInspectionMapper.toDto(savedEntity);
    }
    @Override
    public QualityResponse getQualityInspectionDtoById(int id) {
        QualityInspection existing=qualityInspectionRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        log.info("order response*****"+productionClient.getOrderById(existing.getProductionOrder()).getBody());
        ProductionOrderResponse order=productionClient.getOrderById(existing.getProductionOrder()).getBody();
        EmployeeResponse employee=employeeCustomerClient.getEmployeeById(existing.getInspector()).getBody();
        QualityResponse response =new QualityResponse();
        response.setEmployee(employee);
        response.setProductionOrder(order);
        response.setQuality( qualityInspectionMapper.toDto(existing));
        log.info("response from quality inspection******"+response);
        return response;
    }
    @Override
    public List<QualityInspectionDto> getAllQualityInspectionDto() {
        return qualityInspectionRepository.findAll().stream().map(qualityInspectionMapper::toDto).toList();
    }
    @Override
    public QualityInspectionDto updateQualityInspectionDto(int id, QualityInspectionDto qualityInspectionDto) {
        Boolean productionExist=productionClient.checkOrderExists(qualityInspectionDto.getProductionOrder()).getBody();
        if (Boolean.FALSE.equals(productionExist)) {
            throw new EntityNotFoundException("Production Order not found with id : " + qualityInspectionDto.getProductionOrder());
        }
        Boolean employeeExist=employeeCustomerClient.checkEmployeeExists(qualityInspectionDto.getInspector()).getBody();
        if (Boolean.FALSE.equals(employeeExist)) {
            throw new EntityNotFoundException("Inspector not found with id : " + qualityInspectionDto.getInspector());
        }
        QualityInspection existing=qualityInspectionRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        existing.setInspectedAt(qualityInspectionDto.getInspectedAt());
        existing.setInspectionNumber(qualityInspectionDto.getInspectionNumber());
        existing.setRemarks(qualityInspectionDto.getRemarks());
        existing.setInspector(qualityInspectionDto.getInspector());
        existing.setProductionOrder(qualityInspectionDto.getProductionOrder());
        existing.setInspectionResult(qualityInspectionDto.getInspectionResult());
                if(existing.getInspectionResult()==InspectionResult.PASS||existing.getInspectionResult()==InspectionResult.PENDING||existing.getInspectionResult()==InspectionResult.FAIL){
                    NotificationDto dto=new NotificationDto();
                    dto.setNotificationType(NotificationType.QC_FAIL);
                    dto.setRecipientRole(RecipientRole.PLANT_MANAGER);
                    notificationClient.sendNotificationTrigger(dto);
                }
        QualityInspection savedEntity = qualityInspectionRepository.save(existing);
        return qualityInspectionMapper.toDto(savedEntity);
    }
    @Override
    public String deleteQualityInspectionDto(int id) {
        qualityInspectionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        qualityInspectionRepository.deleteById(id);
        return "deleted successfully";
    }
}
