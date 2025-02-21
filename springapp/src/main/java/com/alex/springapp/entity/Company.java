package com.alex.springapp.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Company")
public class Company {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(name = "name")
    public String name;
    @Column(name = "location")
    public String location;
    @Column(name = "industry")
    public String industry;
    @Column(name = "description")
    public String desc;
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
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getIndustry() {
        return industry;
    }
    public void setIndustry(String industry) {
        this.industry = industry;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public Company(int id, String name, String location, String industry, String desc) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.industry = industry;
        this.desc = desc;
    }
    public Company() {
    }
}
