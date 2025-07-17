package com.example.Bai02_baitap.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Builder

@Entity
@Table(name = "buildingrenttype")
public class BuildingRentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JsonBackReference
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "buildingid")
    Building building;

    @JsonBackReference
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "renttypeid")
    RentType rentType;
}
