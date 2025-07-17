package com.example.Bai02_baitap.service;

import com.example.Bai02_baitap.dto.response.BuildingResponse;
import com.example.Bai02_baitap.entity.Building;
import com.example.Bai02_baitap.entity.District;

import java.util.List;
import java.util.Map;

public interface BuildingService {
    List<BuildingResponse> findAll();
    List<BuildingResponse> searchBuilding(Map<String, Object> params);

    List<BuildingResponse> searchByName(String name);
    List<BuildingResponse> searchByNameContaining(String name);
    List<BuildingResponse> searchByNameContainingAndNumOfBasement(String name, Integer numOfBasement);
    List<BuildingResponse> findByNameContainingAndDistrict(String name, Integer districtId);
    List<BuildingResponse> findByNameContainingAndDistrict_Id(String name, Integer districtId);
    List<BuildingResponse> findByNameContainingAndDistrict_NameContaining(String name, String districtName);
    void deleteByIdIn(List<Integer> ids);
}
