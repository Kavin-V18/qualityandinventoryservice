package com.example.quality_inventory.service;

import com.example.quality_inventory.dto.VehicleInventoryDto;
import com.example.quality_inventory.util.InventoryResponse;

import java.util.List;

public interface VehicleInventoryService {

    VehicleInventoryDto createVehicleInventoryDto(VehicleInventoryDto vehicleInventoryDto);
    InventoryResponse getVehicleInventoryDtoById(int id);
    List<VehicleInventoryDto> getAllVehicleInventoryDto();
    VehicleInventoryDto updateVehicleInventoryDto(int id, VehicleInventoryDto vehicleInventoryDto);
    String deleteVehicleInventoryDto(int id);
    Boolean existById(int id);
}
