package com.example.quality_inventory.util;
import com.example.quality_inventory.dto.VehicleInventoryDto;
import com.example.quality_inventory.entity.VehicleInventory;
import org.springframework.stereotype.Component;

@Component
public class VehicleInventoryMapper {

    public VehicleInventoryDto toDto(VehicleInventory vehicleInventory) {
        if (vehicleInventory == null) return null;

        return VehicleInventoryDto.builder().color(vehicleInventory.getColor()).
               vin(vehicleInventory.getVin()).
                createdBy(vehicleInventory.getCreatedBy()).
                manufacturedDate(vehicleInventory.getManufacturedDate()).
                status(vehicleInventory.getStatus()).
                carModel(vehicleInventory.getCarModel())
                .createdAt(vehicleInventory.getCreatedAt()).
                lastModifiedBy(vehicleInventory.getLastModifiedBy()).
                lastModifiedAt(vehicleInventory.getLastModifiedAt()).
                productionOrders(vehicleInventory.getProductionOrders()).
                build();
    }
    public VehicleInventory toEntity(VehicleInventoryDto dto) {
        if (dto == null) return null;
        VehicleInventory vehicleInventory = new VehicleInventory();
        vehicleInventory.setColor(dto.getColor());
        vehicleInventory.setVin(dto.getVin());
        vehicleInventory.setManufacturedDate(dto.getManufacturedDate());
        vehicleInventory.setProductionOrders(dto.getProductionOrders());
        vehicleInventory.setStatus(dto.getStatus());
        vehicleInventory.setCarModel(dto.getCarModel());
        vehicleInventory.setCreatedBy(dto.getCreatedBy());
        vehicleInventory.setLastModifiedBy(dto.getLastModifiedBy());
        return vehicleInventory;
    }
}
