package com.example.QuantityandInventoryModule.util;

import com.example.QuantityandInventoryModule.dto.QualityInspectionDto;
import com.example.QuantityandInventoryModule.entity.QualityInspection;
import org.springframework.stereotype.Component;

@Component
public class QualityInspectionMapper {

    public QualityInspectionDto toDto(QualityInspection qualityInspection) {
        if (qualityInspection == null) return null;

        return QualityInspectionDto.builder().
                inspection_number(qualityInspection.getInspection_number()).
                production_order(qualityInspection.getProduction_order()).
                inspector(qualityInspection.getInspector()).
                remarks(qualityInspection.getRemarks()).
                inspection_result(qualityInspection.getInspection_result()).
                inspected_at(qualityInspection.getInspected_at()).
                created_by(qualityInspection.getCreated_by()).
                created_at(qualityInspection.getCreated_at()).
                last_modified_by(qualityInspection.getLast_modified_by()).
                last_modified_at(qualityInspection.getLast_modified_at()).
                build();
    }
    public QualityInspection toEntity(QualityInspectionDto dto) {
        if (dto == null) return null;
        QualityInspection qualityInspection = new QualityInspection();
         qualityInspection.setInspection_number(dto.getInspection_number());
         qualityInspection.setProduction_order(dto.getProduction_order());
         qualityInspection.setInspector(dto.getInspector());
         qualityInspection.setRemarks(dto.getRemarks());
         qualityInspection.setInspection_result(dto.getInspection_result());
         qualityInspection.setInspected_at(dto.getInspected_at());
        return qualityInspection;
    }
}
