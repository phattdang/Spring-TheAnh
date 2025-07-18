package com.example.Bai02_baitap.controller;

import com.example.Bai02_baitap.dto.request.BuildingCreationRequest;
import com.example.Bai02_baitap.dto.request.BuildingUpdationRequest;
import com.example.Bai02_baitap.dto.response.BuildingResponse;
import com.example.Bai02_baitap.service.BuildingService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buildings")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class BuildingController {
    BuildingService buildingService;

    @GetMapping
    List<BuildingResponse> getAll() {
        return buildingService.findAll();
    }

    @GetMapping("/search")
    List<BuildingResponse> searchBuilding(@RequestParam Map<String, Object> params) {
        return buildingService.searchBuilding(params);
    }

    @GetMapping("/search/{name}")
    List<BuildingResponse> searchByName(@PathVariable String name){
        return buildingService.searchByName(name);
    }

    @GetMapping("/search/namecontaining/{name}")
    List<BuildingResponse> searchByNameContaining(@PathVariable String name){
        return buildingService.searchByNameContaining(name);
    }

    @GetMapping("/search/namecontaining/{name}/{numOfBasement}")
    List<BuildingResponse> searchByNameContainingAndNumOfBasement(@PathVariable String name, @PathVariable Integer numOfBasement){
        return buildingService.searchByNameContainingAndNumOfBasement(name, numOfBasement);
    }

    @GetMapping("/search/namecontaining/{name}/districtid/{districtId}")
    List<BuildingResponse> findByNameContainingAndDistrict_Id(@PathVariable String name, @PathVariable Integer districtId){
        return buildingService.findByNameContainingAndDistrict_Id(name, districtId);
    }

    @GetMapping("/search/namecontaining/{name}/district/{districtId}")
    List<BuildingResponse> findByNameContainingAndDistrict(@PathVariable String name, @PathVariable Integer districtId){
        return buildingService.findByNameContainingAndDistrict(name, districtId);
    }

    @GetMapping("/search/namecontaining/{name}/districtname/{districtName}")
    List<BuildingResponse> findByNameContainingAndDistrict_NameContaining(@PathVariable String name, @PathVariable String districtName){
        return buildingService.findByNameContainingAndDistrict_NameContaining(name, districtName);
    }

    @GetMapping("/hello")
    String sayHello(){
        return "hello render";
    }

    @DeleteMapping("/{ids}")
    @Transactional
    public void deleteBuilding(@PathVariable List<Integer> ids){
        buildingService.deleteByIdIn(ids);
    }

    @PostMapping
    void addBuilding(@RequestBody BuildingCreationRequest request){
        buildingService.addBuilding(request);
    }

    @PutMapping("/{buildingId}")
    void updateBuilding(@PathVariable int buildingId, @RequestBody BuildingUpdationRequest request){
        buildingService.updateBuilding(buildingId, request);
    }
}
