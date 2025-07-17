package com.example.Bai02_baitap.dto.request;

import com.example.Bai02_baitap.entity.Address;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Builder

public class BuildingFilterRequest {
    String type;
    String name;
    String ward;
    String street;
    String districtId;
    int numberOfnBasement;
    int floorArea;
    int rentPrice;
}
