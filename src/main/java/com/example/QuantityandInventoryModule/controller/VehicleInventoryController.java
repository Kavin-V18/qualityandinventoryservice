package com.example.QuantityandInventoryModule.controller;

import com.example.QuantityandInventoryModule.dto.VehicleInventoryDto;
import com.example.QuantityandInventoryModule.service.VehicleInventoryService;
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
    public List<VehicleInventoryDto> getQualityInspectionDto() {
        return vehicleInventoryService.getAllVehicleInventoryDto();
    }
    @PostMapping()
    public  String createQualityInspectionDto(@Valid @RequestBody VehicleInventoryDto vehicleInventoryDto){
        vehicleInventoryService.createVehicleInventoryDto(vehicleInventoryDto);
        return  "QualityInspection Created Successfully";
    }
    @GetMapping("/{id}")
    public VehicleInventoryDto getQualityInspectionDtoById(@PathVariable int id){
        return vehicleInventoryService.getVehicleInventoryDtoById(id);
    }
    @PostMapping("/{id}")
    public VehicleInventoryDto updateQualityInspectionDto(@PathVariable int id,@Valid @RequestBody VehicleInventoryDto vehicleInventoryDto){
        return  vehicleInventoryService.updateVehicleInventoryDto(id, vehicleInventoryDto);
    }
    @DeleteMapping("/{id}")
    public String deleteQualityInspectionDto(@PathVariable int id){
        vehicleInventoryService.deleteVehicleInventoryDto(id);
        return "QualityInspection Deleted Successfully";
    }
}
