package com.example.Bai02_baitap.mapper;

import com.example.Bai02_baitap.dto.request.BuildingCreationRequest;
import com.example.Bai02_baitap.dto.request.BuildingFilterRequest;
import com.example.Bai02_baitap.dto.request.BuildingUpdationRequest;
import com.example.Bai02_baitap.dto.response.BuildingResponse;
import com.example.Bai02_baitap.entity.Building;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BuildingMapper {
    Building toBuilding(BuildingFilterRequest request);
    Building toBuilding(BuildingCreationRequest request);
    BuildingResponse toBuildingResponse(Building building);
    void updateBuilding(@MappingTarget Building building, BuildingUpdationRequest request);
}
