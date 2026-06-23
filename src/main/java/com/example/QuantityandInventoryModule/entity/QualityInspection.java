package com.example.QuantityandInventoryModule.entity;

import com.example.EmployeeCustomerModule.entity.Employee;
import com.example.ProductionModule.entity.ProductionOrders;
import com.example.QuantityandInventoryModule.InspectionResult;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="qualityinspection",schema = "public")
@Data
public class QualityInspection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   @GeneratedValue(strategy = GenerationType.AUTO)
    private String inspection_number;
   //foreign key
    private ProductionOrders production_order;
    //foreign key
    private Employee inspector;
    @Enumerated(EnumType.STRING)
    private InspectionResult inspection_result;
    private String remarks;

    private LocalDateTime inspected_at;
}
