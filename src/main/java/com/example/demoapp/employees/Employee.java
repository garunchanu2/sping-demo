package com.example.demoapp.employees;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
//@Table(name="tpl_e,ployee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

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


}
