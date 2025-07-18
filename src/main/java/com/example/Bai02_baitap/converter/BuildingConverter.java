package com.example.Bai02_baitap.converter;

import com.example.Bai02_baitap.dto.request.BuildingCreationRequest;
import com.example.Bai02_baitap.dto.response.BuildingResponse;
import com.example.Bai02_baitap.entity.Building;
import com.example.Bai02_baitap.entity.District;
import com.example.Bai02_baitap.repository.DistrictRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class BuildingConverter {

    ModelMapper mapper;
    DistrictRepository districtRepository;
    public BuildingResponse toBuildingResponse(Building b){
        BuildingResponse buildingResponse = mapper.map(b, BuildingResponse.class);
        buildingResponse.setAddress(b.getStreet() + ", " + b.getWard() + ", " + b.getDistrict().getName());
        String rent = b.getRentAreaList().stream().map(r -> String.valueOf(r.getValue()))
                .collect(Collectors.joining(","));
        buildingResponse.setRentAreaValueList(rent);
        return buildingResponse;
    }

    public Building toBuilding(BuildingCreationRequest b){
        Building building = mapper.map(b, Building.class);
        District district = districtRepository.findById(b.getDistrictId())
                .orElse(null);
        building.setDistrict(district);
        return building;
    }
}
