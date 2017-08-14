package com.example.demo2.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "data")
public class Data {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "nrp", unique = true)
    private int nrp;

    @NotNull
    @Column(name = "name")
    private String name;

    public Data() {

    }

    public Data(int id, int nrp, String name) {
        this.id = id;
        this.nrp = nrp;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNrp() {
        return nrp;
    }

    public void setNrp(int nrp) {
        this.nrp = nrp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
