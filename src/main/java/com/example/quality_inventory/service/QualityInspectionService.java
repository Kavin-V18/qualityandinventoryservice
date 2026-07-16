package com.example.quality_inventory.service;

import com.example.quality_inventory.dto.QualityInspectionDto;
import com.example.quality_inventory.util.QualityResponse;


import java.util.List;

public interface QualityInspectionService {

    QualityInspectionDto createQualityInspectionDto(QualityInspectionDto qualityInspectionDto);
    QualityResponse getQualityInspectionDtoById(int id);
    List<QualityInspectionDto> getAllQualityInspectionDto();
    QualityInspectionDto updateQualityInspectionDto(int id, QualityInspectionDto qualityInspectionDto);
    String deleteQualityInspectionDto(int id);
}
