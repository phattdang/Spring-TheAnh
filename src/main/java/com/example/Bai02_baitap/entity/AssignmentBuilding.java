package com.example.Bai02_baitap.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

@Entity
@Table(name = "assignmentbuilding")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AssignmentBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    int id;

    @ToString.Exclude
    @ManyToOne()
    @JoinColumn(name = "buildingid")
    private Building building;

    @ToString.Exclude
    @ManyToOne()
    @JoinColumn(name = "staffid")
    private User user;

    @Column(name = "createddate")
    LocalDate createdDate;
    @Column(name = "modifieddate")
    LocalDate modifiedDate;
    @Column(name = "createdby")
    String createdBy;
    @Column(name = "modifiedby")
    String modifiedBy;
}
