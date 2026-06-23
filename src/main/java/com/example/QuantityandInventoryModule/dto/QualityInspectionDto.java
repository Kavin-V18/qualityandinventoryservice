package com.example.QuantityandInventoryModule.dto;

import com.example.EmployeeCustomerModule.entity.Employee;
import com.example.ProductionModule.entity.ProductionOrders;
import com.example.QuantityandInventoryModule.InspectionResult;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class QualityInspectionDto {

    private String inspection_number;
    //foreign key
    private ProductionOrders production_order;
    //foreign key
    private Employee inspector;
    private InspectionResult inspection_result;
    private String remarks;
    private LocalDateTime inspected_at;
}
