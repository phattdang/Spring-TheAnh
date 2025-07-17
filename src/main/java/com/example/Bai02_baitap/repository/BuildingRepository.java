package com.example.Bai02_baitap.repository;

import com.example.Bai02_baitap.entity.Building;
import com.example.Bai02_baitap.entity.District;
import com.example.Bai02_baitap.repository.custom.BuildingRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer>, BuildingRepositoryCustom {
    List<Building> findByName(String name);
    List<Building> findByNameContaining(String name);
    List<Building> findByNameContainingAndNumberOfnBasement(String name, Integer numOfBasement);
    List<Building> findByNameContainingAndDistrict(String name, District districtId);
    List<Building> findByNameContainingAndDistrict_Id(String name, Integer districtId);
    List<Building> findByNameContainingAndDistrict_NameContaining(String name, String districtName);
    void deleteByIdIn(List<Integer> ids);
}
