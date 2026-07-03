package com.example.quality_inventory.util;

import com.example.quality_inventory.dto.EmployeeDto;
import com.example.quality_inventory.dto.ProductionOrdersDto;
import com.example.quality_inventory.dto.QualityInspectionDto;
import lombok.Data;

@Data
public class QualityResponse {

    private ProductionOrdersDto productionOrder;
    private EmployeeDto employee;
    private QualityInspectionDto quality;
}
