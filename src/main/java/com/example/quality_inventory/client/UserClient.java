package com.example.quality_inventory.client;

import com.example.quality_inventory.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "APIgateway",
        url = "http://localhost:8080")
public interface UserClient {
    @GetMapping("/plant-managers")
    List<UserDto> getPlantManagers();
}
