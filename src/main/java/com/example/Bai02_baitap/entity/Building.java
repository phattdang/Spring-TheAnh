package com.example.Bai02_baitap.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "building")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    Integer id;

    String name;
    String street;
    String ward;

    @JsonBackReference
    @ToString.Exclude
    @ManyToOne()
    @JoinColumn(name = "districtid")
    District district;

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

    @JsonManagedReference
    @ToString.Exclude
    @OneToMany(mappedBy = "building")
    List<RentArea> rentAreaList;

    @JsonManagedReference
    @ToString.Exclude
    @OneToMany(mappedBy = "building")
    List<BuildingRentType> buildingRentType;

    @ToString.Exclude
    @OneToMany(mappedBy = "building")
    private List<AssignmentBuilding> assignmentBuildingList;
}
