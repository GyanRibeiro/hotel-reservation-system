package com.desafiotecnico.eclipsehotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer roomNumber;
    private String roomType;
    private Double price;

    public Rooms() {

    }

    public Rooms(Integer roomNumber, String roomType, Double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
    }
}
