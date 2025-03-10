package com.desafiotecnico.eclipsehotel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Customer")
@Getter@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String phone;

    public Customer() {

    }

    public Customer( String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
