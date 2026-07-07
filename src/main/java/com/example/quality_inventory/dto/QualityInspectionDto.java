package com.example.quality_inventory.dto;

import com.example.quality_inventory.InspectionResult;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QualityInspectionDto {

    private String inspectionNumber;
    //foreign key-production order
    private Long productionOrder;
    //foreign key-employee
    private Long inspector;
    @Enumerated(EnumType.STRING)
    private InspectionResult inspectionResult;
    private String remarks;
    private LocalDateTime inspectedAt;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime lastModifiedAt;
    private Long lastModifiedBy;
}
