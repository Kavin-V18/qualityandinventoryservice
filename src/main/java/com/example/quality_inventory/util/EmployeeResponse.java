package com.example.quality_inventory.util;


import com.example.quality_inventory.dto.EmployeeDto;
import com.example.quality_inventory.dto.ManufacturingPlantDto;
import lombok.Data;

@Data
public class EmployeeResponse {
    private EmployeeDto employee;
    private ManufacturingPlantDto manufacturingPlant;
}
