package com.alex.springapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "JobApplication")
public class JobApplication {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(name = "seekerName")
    public String name;

    @ManyToOne
    @JoinColumn(name = "jobSeeker_id", referencedColumnName = "Id", nullable = false)
    private JobSeeker jobseeker;

    @ManyToOne(optional = false)
    @JoinColumn(name = "job_id", referencedColumnName = "id", nullable = false)
    private Jobs job;

    @Column(name = "company")
    public String company;
    @Column(name = "ApplicationStatus")
    public String status;
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
    public JobSeeker getJobseeker() {
        return jobseeker;
    }
    public void setJobseeker(JobSeeker jobseeker) {
        this.jobseeker = jobseeker;
    }
    public Jobs getJob() {
        return job;
    }
    public void setJob(Jobs job) {
        this.job = job;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public JobApplication(int id, String name, JobSeeker jobseeker, Jobs job, String company, String status) {
        this.id = id;
        this.name = name;
        this.jobseeker = jobseeker;
        this.job = job;
        this.company = company;
        this.status = status;
    }
    public JobApplication() {
    }
    
    

    
    
}
