package com.example.quality_inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductionOrdersDto {
    private String orderNumber;
    //foreignkey--manufacturing plant
    private Long manufacturingPlant;
    //foreignkey-car model
    private Long carModel;
    private String status;
    private Integer targetQuantity;
    private Integer completedQuantity;
    private LocalDate expectedEndDate;
    private LocalDate actualEndDate;
    private LocalDate createdAt;
    private Long createdBy;
    private LocalDate lastModifiedAt;
    private Long lastModifiedBy;
}
