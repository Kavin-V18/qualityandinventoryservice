package com.example.QuantityandInventoryModule.service;

import com.example.QuantityandInventoryModule.dto.QualityInspectionDto;


import java.util.List;

public interface QualityInspecttionService {

    QualityInspectionDto createQualityInspectionDto(QualityInspectionDto qualityInspectionDto);
    QualityInspectionDto getQualityInspectionDtoById(int id);
    List<QualityInspectionDto> getAllQualityInspectionDto();
    QualityInspectionDto updateQualityInspectionDto(int id, QualityInspectionDto qualityInspectionDto);
    String deleteQualityInspectionDto(int id);
}
