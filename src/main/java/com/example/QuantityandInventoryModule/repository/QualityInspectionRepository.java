package com.example.QuantityandInventoryModule.repository;

import com.example.QuantityandInventoryModule.entity.QualityInspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualityInspectionRepository extends JpaRepository<QualityInspection,Integer> {
}
