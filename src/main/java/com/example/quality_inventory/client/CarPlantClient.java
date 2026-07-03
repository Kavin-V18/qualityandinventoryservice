package com.example.quality_inventory.client;

import com.example.quality_inventory.dto.CarModelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "PlantsCarModule",
        url = "http://localhost:8082")
public interface CarPlantClient {
    @GetMapping("/carmodel/{id}")
    ResponseEntity<CarModelDto> getCarModelById(@PathVariable("id") Long id);

    @GetMapping("/carmodel/{id}/exists")
    ResponseEntity<Boolean> checkCarModelExists(@PathVariable("id") Long id);
}
