package com.example.quality_inventory.service;

import com.example.quality_inventory.client.CarPlantClient;
import com.example.quality_inventory.client.ProductionClient;
import com.example.quality_inventory.dto.CarModelDto;
import com.example.quality_inventory.dto.VehicleInventoryDto;
import com.example.quality_inventory.entity.VehicleInventory;
import com.example.quality_inventory.repository.VehicleInventoryRepository;
import com.example.quality_inventory.util.InventoryResponse;
import com.example.quality_inventory.util.ProductionOrderResponse;
import com.example.quality_inventory.util.VehicleInventoryMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VehicleInventoryServiceImp implements VehicleInventoryService {
     private final VehicleInventoryRepository vehicleInventoryRepository;
     private final VehicleInventoryMapper vehicleInventoryMapper;
     private final ProductionClient productionClient;
     private final CarPlantClient carPlantClient;

    @Override
    public VehicleInventoryDto createVehicleInventoryDto(VehicleInventoryDto vehicleInventoryDto) {

    Boolean modelExists = carPlantClient.checkCarModelExists(vehicleInventoryDto.getCarModel()).getBody();
        if (Boolean.FALSE.equals(modelExists)) {
        throw new EntityNotFoundException("Car Model not found with id : " + vehicleInventoryDto.getCarModel());
    }
        Boolean productionExist=productionClient.checkOrderExists(vehicleInventoryDto.getProductionOrders()).getBody();
        if (Boolean.FALSE.equals(productionExist)) {
            throw new EntityNotFoundException("Production Order not found with id : " + vehicleInventoryDto.getProductionOrders());
        }
        VehicleInventory entity = vehicleInventoryMapper.toEntity(vehicleInventoryDto);
        VehicleInventory savedEntity = vehicleInventoryRepository.save(entity);
        return vehicleInventoryMapper.toDto(savedEntity);
    }
    @Override
    public InventoryResponse getVehicleInventoryDtoById(int id) {
        VehicleInventory existing=vehicleInventoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        CarModelDto model = carPlantClient.getCarModelById(existing.getCarModel()).getBody();
        ProductionOrderResponse order=productionClient.getOrderById(existing.getProductionOrders()).getBody();
        InventoryResponse response =new InventoryResponse();
           response.setCarModel(model);
           response.setProductionOrders(order);
           response.setVehicleInventory(vehicleInventoryMapper.toDto(existing));
        return response;
    }
    @Override
    public List<VehicleInventoryDto> getAllVehicleInventoryDto() {
        return vehicleInventoryRepository.findAll().stream().map(vehicleInventoryMapper::toDto).toList();
    }
    @Override
    public VehicleInventoryDto updateVehicleInventoryDto(int id, VehicleInventoryDto vehicleInventoryDto) {
        Boolean modelExists = carPlantClient.checkCarModelExists(vehicleInventoryDto.getCarModel()).getBody();
        if (Boolean.FALSE.equals(modelExists)) {
            throw new EntityNotFoundException("Car Model not found with id : " + vehicleInventoryDto.getCarModel());
        }
        Boolean productionExist=productionClient.checkOrderExists(vehicleInventoryDto.getProductionOrders()).getBody();
        if (Boolean.FALSE.equals(productionExist)) {
            throw new EntityNotFoundException("Production Order not found with id : " + vehicleInventoryDto.getProductionOrders());
        }
        VehicleInventory existing=vehicleInventoryRepository.findById(id).orElseThrow( EntityNotFoundException::new);
        existing.setCarModel(vehicleInventoryDto.getCarModel());
        existing.setStatus(vehicleInventoryDto.getStatus());
        existing.setProductionOrders(vehicleInventoryDto.getProductionOrders());
        existing.setManufacturedDate(vehicleInventoryDto.getManufacturedDate());
        existing.setVin(vehicleInventoryDto.getVin());
        existing.setColor(vehicleInventoryDto.getColor());
        VehicleInventory savedEntity = vehicleInventoryRepository.save(existing);
        return vehicleInventoryMapper.toDto(savedEntity);
    }
    @Override
    public String deleteVehicleInventoryDto(int id) {
        vehicleInventoryRepository.findById(id).orElseThrow( EntityNotFoundException::new);
        vehicleInventoryRepository.deleteById(id);
        return "deleted successfully";
    }
}
