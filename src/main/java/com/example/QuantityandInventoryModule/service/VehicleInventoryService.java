package com.example.QuantityandInventoryModule.service;

import com.example.QuantityandInventoryModule.dto.VehicleInventoryDto;

import java.util.List;

public interface VehicleInventoryService {

    VehicleInventoryDto createVehicleInventoryDto(VehicleInventoryDto vehicleInventoryDto);
    VehicleInventoryDto getVehicleInventoryDtoById(int id);
    List<VehicleInventoryDto> getAllVehicleInventoryDto();
    VehicleInventoryDto updateVehicleInventoryDto(int id, VehicleInventoryDto vehicleInventoryDto);
    String deleteVehicleInventoryDto(int id);
}
