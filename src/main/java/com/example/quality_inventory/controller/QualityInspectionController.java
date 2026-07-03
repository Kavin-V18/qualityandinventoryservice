package com.example.quality_inventory.controller;

import com.example.quality_inventory.dto.QualityInspectionDto;
import com.example.quality_inventory.service.QualityInspecttionService;
import com.example.quality_inventory.util.QualityResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/qualityinspection")
@RequiredArgsConstructor
public class QualityInspectionController {
    private final QualityInspecttionService  qualityInspecttionService;

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
    @PostMapping("/{id}")
    public QualityInspectionDto updateQualityInspectionDto(@PathVariable int id,@Valid @RequestBody QualityInspectionDto qualityInspectionDto){
        return  qualityInspecttionService.updateQualityInspectionDto(id, qualityInspectionDto);
    }
    @DeleteMapping("/{id}")
    public String deleteQualityInspectionDto(@PathVariable int id){
        qualityInspecttionService.deleteQualityInspectionDto(id);
        return "QualityInspection Deleted Successfully";
    }
}
