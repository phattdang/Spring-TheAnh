package com.example.Bai02_baitap.repository;

import com.example.Bai02_baitap.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {
}
