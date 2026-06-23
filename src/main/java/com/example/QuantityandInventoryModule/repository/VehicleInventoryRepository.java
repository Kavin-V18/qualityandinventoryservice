package com.example.QuantityandInventoryModule.repository;

import com.example.QuantityandInventoryModule.entity.VehicleInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleInventoryRepository extends JpaRepository<VehicleInventory,Integer> {
}
