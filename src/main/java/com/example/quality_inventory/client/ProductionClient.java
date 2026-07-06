package com.example.quality_inventory.client;

import com.example.quality_inventory.util.ProductionOrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "ProductionModule",
        url = "http://localhost:8084")
public interface  ProductionClient {
    @GetMapping("/orders/{id}")
    ResponseEntity<ProductionOrderResponse> getOrderById(@PathVariable("id") Long id);
    @GetMapping("/orders/{id}/exists")
    ResponseEntity<Boolean> checkOrderExists(@PathVariable("id") Long id);
}
