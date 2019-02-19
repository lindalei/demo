package com.linda.demo.detail;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

