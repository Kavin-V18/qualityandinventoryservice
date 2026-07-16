package com.example.quality_inventory.client;


import com.example.quality_inventory.dto.AuditLogDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "HistoryAndLogsModule",
        url = "http://localhost:8086")
public interface HistoryLogClient {
    @PostMapping("/auditlog")
    ResponseEntity<Void> sendAuditLog(@RequestBody AuditLogDto request);
}
