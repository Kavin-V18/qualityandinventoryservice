package com.example.quality_inventory.service;

import com.example.quality_inventory.client.UserClient;
import com.example.quality_inventory.dto.UserDto;
import com.example.quality_inventory.entity.QualityInspection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final UserClient userClient;

    private final ResendEmailService resendEmailService;

    public void sendQcFailMail(QualityInspection inspection) {

        List<UserDto> managers = userClient.getPlantManagers();

        if (managers == null || managers.isEmpty()) {
            return;
        }

        String subject = "Quality Inspection Failed";

        String body = """
                Dear Plant Manager,

                Quality Inspection Failed.

                Order Number : %s

                Inspection Number : %s

                Remarks : %s

                Please review immediately.
                """
                .formatted(
                        inspection.getProductionOrder(),
                        inspection.getInspectionNumber(),
                        inspection.getRemarks()
                );

        for (UserDto manager : managers) {

            resendEmailService.sendMail(
                    manager.getEmail(),
                    subject,
                    body
            );

        }

    }

}
