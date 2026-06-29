package com.example.QuantityandInventoryModule.dto;
import com.example.QuantityandInventoryModule.Status;
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
    private Long production_orders;
    @NotBlank
    //foreign key-carModel
    private long carModel;
    @NotBlank
    private String color;
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotBlank
    private LocalDate manufactured_date;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime last_modified_at;
    @NotBlank
    private String created_by;
    @NotBlank
    private String last_modified_by;
}
