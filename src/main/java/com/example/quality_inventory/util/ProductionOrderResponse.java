package com.example.quality_inventory.util;


import com.example.quality_inventory.dto.CarModelDto;
import com.example.quality_inventory.dto.ManufacturingPlantDto;
import com.example.quality_inventory.dto.ProductionOrdersDto;
import lombok.Data;

@Data
public class ProductionOrderResponse {
    private ProductionOrdersDto productionOrder;
    private ManufacturingPlantDto manufacturingPlant;
    private CarModelDto carModel;
}
