package com.example.QuantityandInventoryModule.entity;

import com.example.QuantityandInventoryModule.Status;
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
@SoftDelete(strategy = SoftDeleteType.DELETED, columnName = "deleted")
public class VehicleInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
        private String vin;
        //foreign key-production order
     private Long production_orders;
     //foreign key-car-model
    private Long carModel;
    private String color;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
    private LocalDate manufactured_date;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime last_modified_at;
    @CreatedBy
    private Long created_by;
    @LastModifiedBy
    private Long last_modified_by;
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
}
