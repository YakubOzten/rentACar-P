package com.yakub.rentacar.entites.concretes;

import jakarta.persistence.*;


@Table(name="brands")
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private  String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Brand() {
    }
}

