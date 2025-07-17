package com.example.Bai02_baitap.service.impl;

import com.example.Bai02_baitap.converter.BuildingConverter;
import com.example.Bai02_baitap.dto.response.BuildingResponse;
import com.example.Bai02_baitap.entity.Building;

import com.example.Bai02_baitap.entity.District;
import com.example.Bai02_baitap.mapper.BuildingMapper;
import com.example.Bai02_baitap.repository.BuildingRepository;
import com.example.Bai02_baitap.repository.DistrictRepository;
import com.example.Bai02_baitap.service.BuildingService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BuildingServiceImpl implements BuildingService {
    BuildingRepository buildingRepository;
    BuildingMapper mapper;
    ModelMapper modelMapper;
    BuildingConverter converter;
    DistrictRepository districtRepository;
    public List<BuildingResponse> findAll() {
        List<Building> buildingList = buildingRepository.findAll();

        return buildingList.stream()
                .map(converter::toBuildingResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<BuildingResponse> searchBuilding(Map<String, Object> params) {
        List<Building> buildings = buildingRepository.searchBuilding(params);
        return buildings.stream()
                .map(converter::toBuildingResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<BuildingResponse> searchByName(String name) {
        return buildingRepository.findByName(name)
                .stream()
                .map(converter::toBuildingResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<BuildingResponse> searchByNameContaining(String name) {
        return buildingRepository.findByNameContaining(name)
                .stream()
                .map(converter::toBuildingResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<BuildingResponse> searchByNameContainingAndNumOfBasement(String name, Integer numOfBasement) {
        return buildingRepository.findByNameContainingAndNumberOfnBasement(name, numOfBasement)
                .stream()
                .map(converter::toBuildingResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<BuildingResponse> findByNameContainingAndDistrict(String name, Integer districtId) {
        District district = districtRepository.findById(districtId)
                .orElse(null);

        return buildingRepository.findByNameContainingAndDistrict(name, district)
                .stream()
                .map(converter::toBuildingResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<BuildingResponse> findByNameContainingAndDistrict_Id(String name, Integer districtId) {
        return buildingRepository.findByNameContainingAndDistrict_Id(name, districtId)
                .stream()
                .map(converter::toBuildingResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<BuildingResponse> findByNameContainingAndDistrict_NameContaining(String name, String districtName) {
        return buildingRepository.findByNameContainingAndDistrict_NameContaining(name, districtName)
                .stream()
                .map(converter::toBuildingResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByIdIn(List<Integer> ids) {
        buildingRepository.deleteByIdIn(ids);
    }
}
