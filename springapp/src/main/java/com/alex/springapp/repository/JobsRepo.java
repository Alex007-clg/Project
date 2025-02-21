package com.alex.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.springapp.entity.Jobs;

public interface JobsRepo extends JpaRepository<Jobs,Integer>{
    
}
