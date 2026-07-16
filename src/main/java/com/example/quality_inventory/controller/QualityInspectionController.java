package com.example.quality_inventory.controller;

import com.example.quality_inventory.dto.QualityInspectionDto;
import com.example.quality_inventory.service.QualityInspectionService;
import com.example.quality_inventory.util.QualityResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/qualityinspection")
@RequiredArgsConstructor
@Slf4j
public class QualityInspectionController {
    private final QualityInspectionService qualityInspecttionService;

    @GetMapping()
    public List<QualityInspectionDto> getQualityInspectionDto() {
        return qualityInspecttionService.getAllQualityInspectionDto();
    }
    @PostMapping()
    public  String createQualityInspectionDto(@Valid @RequestBody QualityInspectionDto qualityInspectionDto){
        qualityInspecttionService.createQualityInspectionDto(qualityInspectionDto);
        return  "QualityInspection Created Successfully";
    }
    @GetMapping("/{id}")
    public QualityResponse getQualityInspectionDtoById(@PathVariable int id){
        return qualityInspecttionService.getQualityInspectionDtoById(id);
    }
    @PutMapping("/{id}")
    public QualityInspectionDto updateQualityInspectionDto(@PathVariable int id,@Valid @RequestBody QualityInspectionDto qualityInspectionDto){
        return  qualityInspecttionService.updateQualityInspectionDto(id, qualityInspectionDto);
    }
    @DeleteMapping("/{id}")
    public String deleteQualityInspectionDto(@PathVariable int id){
        qualityInspecttionService.deleteQualityInspectionDto(id);
        return "QualityInspection Deleted Successfully";
    }
}
