package com.example.Bai02_baitap.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BuildingUpdationRequest {
    String name;
    String street;
    String ward;
    int numberOfnBasement;
}
