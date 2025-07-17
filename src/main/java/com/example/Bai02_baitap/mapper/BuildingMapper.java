package com.example.Bai02_baitap.mapper;

import com.example.Bai02_baitap.dto.request.BuildingFilterRequest;
import com.example.Bai02_baitap.dto.response.BuildingResponse;
import com.example.Bai02_baitap.entity.Building;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BuildingMapper {
    Building toBuilding(BuildingFilterRequest request);
    BuildingResponse toBuildingResponse(Building building);
}
