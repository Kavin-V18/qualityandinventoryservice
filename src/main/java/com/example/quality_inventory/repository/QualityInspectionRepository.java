package com.example.quality_inventory.repository;

import com.example.quality_inventory.entity.QualityInspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualityInspectionRepository extends JpaRepository<QualityInspection,Integer> {
}
