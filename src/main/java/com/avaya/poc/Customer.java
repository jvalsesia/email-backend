package com.avaya.poc;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer extends PanacheEntity {

    @Column(nullable = false)
    public String name;

    @Column(nullable = false, unique = true)
    public String email;

    public Customer() {}

    // public Customer(Long id, Strinqg name, String email) {
    //     this.id = id;
    //     this.name = name;
    //     this.email = email;
    // }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }
}