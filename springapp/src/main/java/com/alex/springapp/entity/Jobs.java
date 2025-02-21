package com.alex.springapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Jobs")
public class Jobs {
    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(name = "title")
    public String name;
    @Column(name = "company")
    public String company;
    @Column(name = "location")
    public String location;
    @Column(name = "description")
    public String desc;
    @Column(name = "salary")
    public int salary;
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
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public Jobs(int id, String name, String company, String location, String desc, int salary) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.location = location;
        this.desc = desc;
        this.salary = salary;
    }

    public Jobs() {
        
    }
}
