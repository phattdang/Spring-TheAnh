package com.example.Bai02_baitap.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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

@Entity
@Table(name = "renttype")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String code;
    String name;

    @JsonManagedReference
    @ToString.Exclude
    @OneToMany(mappedBy = "rentType")
    List<BuildingRentType> buildingRentType;
}
