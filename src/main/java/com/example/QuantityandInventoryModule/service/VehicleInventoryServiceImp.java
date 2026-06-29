package com.example.QuantityandInventoryModule.service;

import com.example.QuantityandInventoryModule.dto.VehicleInventoryDto;
import com.example.QuantityandInventoryModule.entity.VehicleInventory;
import com.example.QuantityandInventoryModule.repository.VehicleInventoryRepository;
import com.example.QuantityandInventoryModule.util.VehicleInventoryMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VehicleInventoryServiceImp implements VehicleInventoryService {
     private final VehicleInventoryRepository vehicleInventoryRepository;
     private final VehicleInventoryMapper vehicleInventoryMapper;

    @Override
    public VehicleInventoryDto createVehicleInventoryDto(VehicleInventoryDto vehicleInventoryDto) {
        VehicleInventory entity = vehicleInventoryMapper.toEntity(vehicleInventoryDto); // DTO -> Entity
        VehicleInventory savedEntity = vehicleInventoryRepository.save(entity);
        return vehicleInventoryMapper.toDto(savedEntity);
    }

    @Override
    public VehicleInventoryDto getVehicleInventoryDtoById(int id) {
        VehicleInventory existing=vehicleInventoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        VehicleInventoryDto vehicleInventoryDtos= vehicleInventoryMapper.toDto(existing);
        return  vehicleInventoryDtos;
    }

    @Override
    public List<VehicleInventoryDto> getAllVehicleInventoryDto() {
        return vehicleInventoryRepository.findAll().stream().map(vehicleInventoryMapper::toDto).toList();
    }

    @Override
    public VehicleInventoryDto updateVehicleInventoryDto(int id, VehicleInventoryDto vehicleInventoryDto) {
        VehicleInventory existing=vehicleInventoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        existing.setCarModel(vehicleInventoryDto.getCarModel());
        existing.setStatus(vehicleInventoryDto.getStatus());
        existing.setProduction_orders(vehicleInventoryDto.getProduction_orders());
        existing.setManufactured_date(vehicleInventoryDto.getManufactured_date());
        existing.setVin(vehicleInventoryDto.getVin());
        existing.setColor(vehicleInventoryDto.getColor());
        VehicleInventory savedEntity = vehicleInventoryRepository.save(existing);
        return vehicleInventoryMapper.toDto(savedEntity);
    }

    @Override
    public String deleteVehicleInventoryDto(int id) {
        VehicleInventory existing=vehicleInventoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        vehicleInventoryRepository.deleteById(id);
        return "deleted successfully";
    }
}
