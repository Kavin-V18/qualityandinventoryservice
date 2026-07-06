package com.example.quality_inventory.repository;

import com.example.quality_inventory.entity.VehicleInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleInventoryRepository extends JpaRepository<VehicleInventory,Integer> {
}
