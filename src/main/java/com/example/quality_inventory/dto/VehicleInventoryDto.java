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

    //foreign key
    private Long productionOrders;
    //foreign key-carModel
    private Long carModel;
    @NotBlank
    private String color;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate manufacturedDate;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime lastModifiedAt;
    private Long createdBy;
    private Long lastModifiedBy;
}
