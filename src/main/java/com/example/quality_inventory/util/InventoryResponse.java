package com.example.quality_inventory.util;

import com.example.quality_inventory.dto.CarModelDto;
import com.example.quality_inventory.dto.ProductionOrdersDto;
import com.example.quality_inventory.dto.VehicleInventoryDto;
import lombok.Data;
@Data
public class InventoryResponse {
    private ProductionOrdersDto productionOrders;
    private CarModelDto carModel;
    private VehicleInventoryDto vehicleInventory;
}
