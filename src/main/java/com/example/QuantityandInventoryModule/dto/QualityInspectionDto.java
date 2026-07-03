package com.example.QuantityandInventoryModule.dto;

import com.example.QuantityandInventoryModule.InspectionResult;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QualityInspectionDto {

    private String inspection_number;
    //foreign key-production order
    private Long production_order;
    //foreign key-employee
    @NotBlank
    private Long inspector;
    @Enumerated(EnumType.STRING)
    private InspectionResult inspection_result;
    private String remarks;
    private LocalDateTime inspected_at;
    @NotBlank
    private LocalDateTime created_at;
    @NotBlank
    private Long created_by;
    @NotBlank
    private LocalDateTime last_modified_at;
    @NotBlank
    private Long last_modified_by;
}
