package com.example.QuantityandInventoryModule.entity;

import com.example.PlantsCarModule.entity.CarModel;
import com.example.ProductionModule.entity.ProductionOrders;
import com.example.QuantityandInventoryModule.Status;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;


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
}
