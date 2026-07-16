package com.example.quality_inventory.dto;

import com.example.quality_inventory.util.NotificationType;
import com.example.quality_inventory.util.RecipientRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDto {
    private RecipientRole recipientRole;
    private NotificationType notificationType;
}
