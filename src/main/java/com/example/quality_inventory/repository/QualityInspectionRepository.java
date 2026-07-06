package com.example.quality_inventory.repository;

import com.example.quality_inventory.entity.QualityInspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualityInspectionRepository extends JpaRepository<QualityInspection,Integer> {
}
