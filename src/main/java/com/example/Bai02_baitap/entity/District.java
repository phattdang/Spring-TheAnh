package com.example.Bai02_baitap.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "district")
public class District {
    @Id
    @EqualsAndHashCode.Include
    Integer id;

    String code;
    String name;

    @JsonManagedReference
    @ToString.Exclude
    @OneToMany(mappedBy = "district")
    List<Building> buildingList;
}
