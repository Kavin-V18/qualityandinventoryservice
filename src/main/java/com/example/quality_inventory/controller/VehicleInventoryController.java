package com.example.quality_inventory.controller;

import com.example.quality_inventory.dto.VehicleInventoryDto;
import com.example.quality_inventory.service.VehicleInventoryService;
import com.example.quality_inventory.util.InventoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicleinventory")
@RequiredArgsConstructor
public class VehicleInventoryController {
    private final VehicleInventoryService vehicleInventoryService;

    @GetMapping()
    public List<VehicleInventoryDto> getVehicleInventoryDto() {
        return vehicleInventoryService.getAllVehicleInventoryDto();
    }
    @PostMapping()
    public  String createVehicleInventoryDto(@Valid @RequestBody VehicleInventoryDto vehicleInventoryDto){
        vehicleInventoryService.createVehicleInventoryDto(vehicleInventoryDto);
        return  "QualityInspection Created Successfully";
    }
    @GetMapping("/{id}")
    public InventoryResponse getVehicleInventoryDtoById(@PathVariable int id){
        return vehicleInventoryService.getVehicleInventoryDtoById(id);
    }
    @PutMapping("/{id}")
    public VehicleInventoryDto updateVehicleInventoryDto(@PathVariable int id,@Valid @RequestBody VehicleInventoryDto vehicleInventoryDto){
        return  vehicleInventoryService.updateVehicleInventoryDto(id, vehicleInventoryDto);
    }
    @DeleteMapping("/{id}")
    public String deleteVehicleInventoryDto(@PathVariable int id){
        vehicleInventoryService.deleteVehicleInventoryDto(id);
        return "QualityInspection Deleted Successfully";
    }
    @GetMapping("/{id}/exists")
    Boolean checkInventoryExists(@PathVariable("id") int id){
        return vehicleInventoryService.existById(id);
    }
}
