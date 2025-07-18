package com.example.Bai02_baitap.dto.request;

import com.example.Bai02_baitap.entity.District;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class BuildingCreationRequest {
    String name;
    String street;
    String ward;
    int numberOfnBasement;
    int districtId;
}
