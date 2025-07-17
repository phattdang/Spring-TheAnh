package com.example.Bai02_baitap.dto.response;

import com.example.Bai02_baitap.entity.Address;
import com.example.Bai02_baitap.entity.BuildingRentType;
import com.example.Bai02_baitap.entity.District;
import com.example.Bai02_baitap.entity.RentArea;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Builder

public class BuildingResponse {
    String name;
    @Embedded
    String address ;
    @Column(name = "numberofbasement")
    int numberOfnBasement;
    @Column(name = "floorarea")
    int floorArea;
    @Column(name = "rentprice")
    int rentPrice;
    @Column(name = "rentpricedescription")
    String rentPriceDescription;
    @Column(name = "servicefee")
    String serviceFee;
    @Column(name = "managername")
    String managerName;
    @Column(name = "managerphonenumber")
    String managerPhoneNumber;
    String rentAreaValueList;
}
