package com.example.Bai02_baitap.repository.custom;

import com.example.Bai02_baitap.entity.Building;

import java.util.List;
import java.util.Map;

public interface BuildingRepositoryCustom {
    List<Building> getAll();
    List<Building> searchBuilding(Map<String, Object> params);
}
