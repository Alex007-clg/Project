package com.alex.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.alex.springapp.entity.JobSeeker;
import com.alex.springapp.service.JobSeekerService;

@Controller
public class JobSeekerController {
    @Autowired
    JobSeekerService obj;

    @GetMapping("/api/jobseekers/get")
    public ResponseEntity<List<JobSeeker>> getAllUsers() {
        return new ResponseEntity<>(obj.getAllSeekers(), HttpStatus.OK);
    }
    @PostMapping("/api/jobseekers/post")
    public ResponseEntity<JobSeeker> PostData(@RequestBody JobSeeker mess) {
        return new ResponseEntity<>(obj.PostData(mess), HttpStatus.OK);

    }
    @PutMapping("/api/jobseekers/update/{id}")
    public ResponseEntity<?> UpdateData(@RequestBody JobSeeker mess, @PathVariable int id) {
        Optional<JobSeeker> data = obj.UpdateUser(mess, id);
        if (data.isPresent()) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("ID not found");

    }
    @DeleteMapping("/api/jobseekers/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        Optional<JobSeeker> data = obj.deleteUser(id);
        if (data.isPresent()) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("ID not found");
    }
    @GetMapping("/api/jobseekers/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        Optional<JobSeeker> data = obj.getSingleUser(id);
        if (data.isPresent()) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("ID not found");
    }
}
