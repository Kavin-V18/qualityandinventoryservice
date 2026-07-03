package com.example.quality_inventory.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private String employeeCode;
    @NotNull
    private String fullName;
    @NotNull
    private String designation;
    private LocalDate dateOfBirth;
    private LocalDate joiningDate;
    private  boolean active;
    //foreign key for plant //need to map
    private byte[] profileImage;
    private Long manufacturingPlant;
    private LocalDate createdAt;
    private LocalDate lastModifiedAt;
    private Long createdBy;
    private Long lastModifiedBy;
}
