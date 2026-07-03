package com.example.quality_inventory.dto;
import com.example.quality_inventory.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleInventoryDto {

    @NotBlank
    private String vin;
    @NotBlank
    //foreign key-producton order
    private Long productionOrders;
    @NotBlank
    //foreign key-carModel
    private long carModel;
    @NotBlank
    private String color;
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotBlank
    private LocalDate manufacturedDate;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime lastModifiedAt;
    @NotBlank
    private Long createdBy;
    @NotBlank
    private Long lastModifiedBy;
}
