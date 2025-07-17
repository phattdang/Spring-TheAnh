package com.example.Bai02_baitap.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Builder

@Entity
@Table(name = "rentarea")
public class RentArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int value;

    @JsonBackReference
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "buildingid")

    Building building;
    @Column(name = "createddate")
    LocalDate createdDate;
    @Column(name = "modifieddate")
    LocalDate modifiedDate;
    @Column(name = "createdby")
    String createdBy;
    @Column(name = "modifiedby")
    String modifiedBy;
}
