package com.example.QuantityandInventoryModule.entity;

import com.example.PlantsCarModule.entity.CarModel;
import com.example.ProductionModule.entity.ProductionOrders;
import com.example.QuantityandInventoryModule.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Table(name = "vehicleinventory",schema = "public")
@Entity
@Data
public class VehicleInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
        private String vin;
        //foreign key
     private ProductionOrders production_orders;
     //foreign key
    private CarModel carModel;
    private String color;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate manufactured_date;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime last_modified_at;
    private String created_by;
    private String last_modified_by;
}
