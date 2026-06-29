package com.example.QuantityandInventoryModule.entity;

import com.example.QuantityandInventoryModule.InspectionResult;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name="qualityinspection",schema = "public")
@Data
public class QualityInspection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String inspection_number;
   //foreign key-production order
    private Long production_order;
    //foreign key-employee
    private Long inspector;
    @Enumerated(EnumType.STRING)
    private InspectionResult inspection_result;
    private String remarks;
    private LocalDateTime inspected_at;
    @CreationTimestamp
    private LocalDateTime created_at;
    @CreatedBy
    private String created_by;
    @UpdateTimestamp
    private LocalDateTime last_modified_at;
    @LastModifiedBy
    private String last_modified_by;
}
