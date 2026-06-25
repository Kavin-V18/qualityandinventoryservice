package com.example.QuantityandInventoryModule.service;

import com.example.QuantityandInventoryModule.dto.QualityInspectionDto;
import com.example.QuantityandInventoryModule.entity.QualityInspection;
import com.example.QuantityandInventoryModule.repository.QualityInspectionRepository;
import com.example.QuantityandInventoryModule.util.QualityInspectionMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class QualityInspectionServiceImp implements QualityInspecttionService{
      private final QualityInspectionRepository qualityInspectionRepository;
      private final QualityInspectionMapper qualityInspectionMapper;
    @Override
    public QualityInspectionDto createQualityInspectionDto(QualityInspectionDto qualityInspectionDto) {
        QualityInspection entity = qualityInspectionMapper.toEntity(qualityInspectionDto); // DTO -> Entity
        QualityInspection savedEntity = qualityInspectionRepository.save(entity);
        return qualityInspectionMapper.toDto(savedEntity);
    }

    @Override
    public QualityInspectionDto getQualityInspectionDtoById(int id) {
        QualityInspection existing=qualityInspectionRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        QualityInspectionDto qualityInspectionDtos= qualityInspectionMapper.toDto(existing);
        return  qualityInspectionDtos;
    }

    @Override
    public List<QualityInspectionDto> getAllQualityInspectionDto() {
        return qualityInspectionRepository.findAll().stream().map(qualityInspectionMapper::toDto).toList();
    }

    @Override
    public QualityInspectionDto updateQualityInspectionDto(int id, QualityInspectionDto qualityInspectionDto) {
        QualityInspection existing=qualityInspectionRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        existing.setInspected_at(qualityInspectionDto.getInspected_at());
        existing.setInspection_result(qualityInspectionDto.getInspection_result());
        existing.setInspection_number(qualityInspectionDto.getInspection_number());
        existing.setRemarks(qualityInspectionDto.getRemarks());
        existing.setInspector(qualityInspectionDto.getInspector());
        QualityInspection savedEntity = qualityInspectionRepository.save(existing);
        return qualityInspectionMapper.toDto(savedEntity);
    }

    @Override
    public String deleteQualityInspectionDto(int id) {
        QualityInspection existing=qualityInspectionRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        qualityInspectionRepository.deleteById(id);
        return "deleted successfully";
    }
}
