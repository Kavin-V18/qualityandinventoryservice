package com.example.quality_inventory.entity;

import com.example.quality_inventory.InspectionResult;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name="qualityinspection",schema = "public")
@Data
@EntityListeners(AuditingEntityListener.class)
@SoftDelete(strategy = SoftDeleteType.ACTIVE)
public class QualityInspection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="inspection_number")
    private String inspectionNumber;
   //foreign key-production order
   @Column(name="production_order")
    private Long productionOrder;
    //foreign key-employee
    private Long inspector;
    @Enumerated(EnumType.STRING)
    @Column(name="inspection_result")
    private InspectionResult inspectionResult;
    private String remarks;
    @Column(name="inspected_at")
    private LocalDateTime inspectedAt;
    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @CreatedBy
    @Column(name="created_by")
    private Long createdBy;
    @UpdateTimestamp
    @Column(name="last_modified_at")
    private LocalDateTime lastModifiedAt;
    @LastModifiedBy
    @Column(name="last_modified_by")
    private Long lastModifiedBy;
}
