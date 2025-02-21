package com.alex.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.springapp.entity.JobSeeker;

public interface JobSeekerRepo extends JpaRepository<JobSeeker,Integer>{
    
}
