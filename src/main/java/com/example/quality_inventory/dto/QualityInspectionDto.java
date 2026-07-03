package com.example.quality_inventory.dto;

import com.example.quality_inventory.InspectionResult;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private Long inspector;
    @Enumerated(EnumType.STRING)
    private InspectionResult inspectionResult;
    private String remarks;
    private LocalDateTime inspectedAt;
    @NotBlank
    private LocalDateTime createdAt;
    @NotBlank
    private Long createdBy;
    @NotBlank
    private LocalDateTime lastModifiedAt;
    @NotBlank
    private Long lastModifiedBy;
}
