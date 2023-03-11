package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Player {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

@Column
private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
