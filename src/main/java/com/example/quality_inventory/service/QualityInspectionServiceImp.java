package com.example.quality_inventory.service;

import com.example.quality_inventory.client.EmployeeCustomerClient;
import com.example.quality_inventory.client.ProductionClient;
import com.example.quality_inventory.dto.EmployeeDto;
import com.example.quality_inventory.dto.ProductionOrdersDto;
import com.example.quality_inventory.dto.QualityInspectionDto;
import com.example.quality_inventory.entity.QualityInspection;
import com.example.quality_inventory.repository.QualityInspectionRepository;
import com.example.quality_inventory.util.QualityInspectionMapper;
import com.example.quality_inventory.util.QualityResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class QualityInspectionServiceImp implements QualityInspecttionService{
      private final QualityInspectionRepository qualityInspectionRepository;
      private final QualityInspectionMapper qualityInspectionMapper;
    private final ProductionClient productionClient;
    private final EmployeeCustomerClient employeeCustomerClient;
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
        ProductionOrdersDto order=productionClient.getOrderById(existing.getProductionOrder()).getBody();
        EmployeeDto employee=employeeCustomerClient.getEmployeeById(existing.getInspector()).getBody();
        QualityResponse response =new QualityResponse();
        response.setEmployee(employee);
        response.setProductionOrder(order);
        response.setQuality( qualityInspectionMapper.toDto(existing));
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
            throw new EntityNotFoundException("Production Order not found with id : " + qualityInspectionDto.getInspector());
        }
        QualityInspection existing=qualityInspectionRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        existing.setInspectedAt(qualityInspectionDto.getInspectedAt());
        existing.setInspectionNumber(qualityInspectionDto.getInspectionNumber());
        existing.setRemarks(qualityInspectionDto.getRemarks());
        existing.setInspector(qualityInspectionDto.getInspector());
        existing.setProductionOrder(qualityInspectionDto.getProductionOrder());
        existing.setInspectionResult(qualityInspectionDto.getInspectionResult());
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
