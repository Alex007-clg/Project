package com.alex.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.springapp.entity.JobApplication;

public interface JobApplicationRepo extends JpaRepository<JobApplication,Integer>{

}
