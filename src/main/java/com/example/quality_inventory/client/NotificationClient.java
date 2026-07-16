package com.example.quality_inventory.client;

import com.example.quality_inventory.dto.NotificationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "DeliveryNotificationModule",
        url = "http://localhost:8081"
)
public interface NotificationClient {

    @PostMapping("/notification")
    void sendNotificationTrigger(@RequestBody NotificationDto dto);
}
