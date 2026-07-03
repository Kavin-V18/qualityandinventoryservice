package com.example.quality_inventory.client;

import com.example.quality_inventory.dto.ProductionOrdersDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "ProductionModule",
        url = "http://localhost:8084/orders")
public interface ProductionClient {
    @GetMapping("/{id}")
    ResponseEntity<ProductionOrdersDto> getOrderById(@PathVariable("id") Long id);
    @GetMapping("{id}/exists")
    ResponseEntity<Boolean> checkOrderExists(@PathVariable("id") Long id);
}
