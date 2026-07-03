package com.example.quality_inventory.entity;

import com.example.quality_inventory.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Table(name = "vehicleinventory",schema = "public")
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@SoftDelete(strategy = SoftDeleteType.ACTIVE)
public class VehicleInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
        private String vin;
        //foreign key-production order
        @Column(name="production_orders")
     private Long productionOrders;
     //foreign key-car-model
    private Long carModel;
    private String color;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,name="")
    private Status status;
    @Column(name="manufactured_date")
    private LocalDate manufacturedDate;
    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name="last_modified_at")
    private LocalDateTime lastModifiedAt;
    @CreatedBy
    @Column(name="created_by")
    private Long createdBy;
    @LastModifiedBy
    @Column(name="last_modified_by")
    private Long lastModifiedBy;
}
