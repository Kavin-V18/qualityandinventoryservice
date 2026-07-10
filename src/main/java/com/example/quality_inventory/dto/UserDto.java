package com.example.quality_inventory.dto;

import com.example.quality_inventory.Role;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
}
