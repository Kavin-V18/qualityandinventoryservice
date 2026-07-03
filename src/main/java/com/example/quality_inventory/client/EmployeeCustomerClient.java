package com.example.quality_inventory.client;

import com.example.quality_inventory.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "EmployeeCustomerModule",
        url = "http://localhost:8085")
public interface EmployeeCustomerClient {
    @GetMapping("/employee/{id}")
    ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id);

    @GetMapping("/employee/{id}/exists")
    ResponseEntity<Boolean> checkEmployeeExists(@PathVariable("id") Long id);
}
