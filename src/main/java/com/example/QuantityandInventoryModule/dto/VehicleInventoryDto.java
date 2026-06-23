package com.example.QuantityandInventoryModule.dto;
import com.example.PlantsCarModule.entity.CarModel;
import com.example.ProductionModule.entity.ProductionOrders;
import com.example.QuantityandInventoryModule.Status;
import lombok.Data;

import java.time.LocalDate;
@Data
public class VehicleInventoryDto {
    private String vin;
    //foreign key
    private ProductionOrders production_orders;
    //foreign key
    private CarModel carModel;
    private String color;
    private Status status;
    private LocalDate manufactured_date;
}
