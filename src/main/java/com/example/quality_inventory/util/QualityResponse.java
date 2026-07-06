package com.example.quality_inventory.util;

import com.example.quality_inventory.dto.QualityInspectionDto;
import lombok.Data;

@Data
public class QualityResponse {

    private ProductionOrderResponse productionOrder;
    private EmployeeResponse employee;
    private QualityInspectionDto quality;
}
