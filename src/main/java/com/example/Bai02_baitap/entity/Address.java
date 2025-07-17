package com.example.Bai02_baitap.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Builder

@Embeddable
@Table(name = "building")
public class Address {
    String street;
    String ward;
    String district;
}
