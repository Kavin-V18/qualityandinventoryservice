package com.example.QuantityandInventoryModule.util;

import com.example.QuantityandInventoryModule.dto.VehicleInventoryDto;
import com.example.QuantityandInventoryModule.entity.VehicleInventory;
import org.springframework.stereotype.Component;

@Component
public class VehicleInventoryMapper {

    public VehicleInventoryDto toDto(VehicleInventory vehicleInventory) {
        if (vehicleInventory == null) return null;

        return VehicleInventoryDto.builder().color(vehicleInventory.getColor()).
                id(vehicleInventory.getId()).vin(vehicleInventory.getVin()).
                created_by(vehicleInventory.getCreated_by()).
                manufactured_date(vehicleInventory.getManufactured_date()).
                status(vehicleInventory.getStatus()).
                carModel(vehicleInventory.getCarModel())
                .created_at(vehicleInventory.getCreated_at()).
                last_modified_by(vehicleInventory.getLast_modified_by()).
                last_modified_at(vehicleInventory.getLast_modified_at()).
                production_orders(vehicleInventory.getProduction_orders()).
                build();
    }
    public VehicleInventory toEntity(VehicleInventoryDto dto) {
        if (dto == null) return null;
        VehicleInventory vehicleInventory = new VehicleInventory();
        vehicleInventory.setId(dto.getId());
        vehicleInventory.setColor(dto.getColor());
        vehicleInventory.setVin(dto.getVin());
        vehicleInventory.setManufactured_date(dto.getManufactured_date());
        vehicleInventory.setProduction_orders(dto.getProduction_orders());
        vehicleInventory.setStatus(dto.getStatus());
        vehicleInventory.setCarModel(dto.getCarModel());
        return vehicleInventory;
    }
}
