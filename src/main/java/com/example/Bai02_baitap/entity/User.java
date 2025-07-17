package com.example.Bai02_baitap.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

@Entity
@Table(name = "user")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    int id;

    String username;
    String password;
    @Column(name = "fullname")
    String fullName;
    String phone;
    String email;
    int status;
    @Column(name = "createddate")
    LocalDate createdDate;
    @Column(name = "modifieddate")
    LocalDate modifiedDate;
    @Column(name = "createdby")
    String createdBy;
    @Column(name = "modifiedby")
    String modifiedBy;

    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<AssignmentBuilding> assignmentBuildingList;
}
