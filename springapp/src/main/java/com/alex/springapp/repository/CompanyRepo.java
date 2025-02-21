package com.alex.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.springapp.entity.Company;

public interface CompanyRepo extends JpaRepository<Company,Integer>{
    
}
