package com.example.quality_inventory.util;

import com.example.quality_inventory.dto.QualityInspectionDto;
import com.example.quality_inventory.entity.QualityInspection;
import org.springframework.stereotype.Component;

@Component
public class QualityInspectionMapper {

    public QualityInspectionDto toDto(QualityInspection qualityInspection) {
        if (qualityInspection == null) return null;

        return QualityInspectionDto.builder().
                inspectionNumber(qualityInspection.getInspectionNumber()).
                productionOrder(qualityInspection.getProductionOrder()).
                inspector(qualityInspection.getInspector()).
                remarks(qualityInspection.getRemarks()).
                inspectionResult(qualityInspection.getInspectionResult()).
                inspectedAt(qualityInspection.getInspectedAt()).
                createdBy(qualityInspection.getCreatedBy()).
                createdAt(qualityInspection.getCreatedAt()).
                lastModifiedBy(qualityInspection.getLastModifiedBy()).
                lastModifiedAt(qualityInspection.getLastModifiedAt()).
                build();
    }
    public QualityInspection toEntity(QualityInspectionDto dto) {
        if (dto == null) return null;
        QualityInspection qualityInspection = new QualityInspection();
         qualityInspection.setInspectionNumber(dto.getInspectionNumber());
         qualityInspection.setProductionOrder(dto.getProductionOrder());
         qualityInspection.setInspector(dto.getInspector());
         qualityInspection.setRemarks(dto.getRemarks());
         qualityInspection.setInspectionResult(dto.getInspectionResult());
         qualityInspection.setInspectedAt(dto.getInspectedAt());
         qualityInspection.setCreatedBy(dto.getCreatedBy());
         qualityInspection.setLastModifiedBy(dto.getLastModifiedBy());
        return qualityInspection;
    }
}
