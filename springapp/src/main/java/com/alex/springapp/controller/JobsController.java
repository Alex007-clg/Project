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

import com.alex.springapp.entity.Jobs;
import com.alex.springapp.service.JobsService;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/admins")
public class JobsController {
    @Autowired
    JobsService obj;
    @GetMapping
    public ResponseEntity<List<Jobs>> getAllJobs() {
        return new ResponseEntity<>(obj.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Jobs> postJob(@RequestBody Jobs mess) {
        return new ResponseEntity<>(obj.postJob(mess), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateData(@PathVariable int id, @RequestBody Jobs mess) {
        Optional<Jobs> item = obj.updateData(id, mess);
        if (item.isPresent()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("ID not found!");
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteData(@PathVariable int id)
    {
        Optional<Jobs> item = obj.deleteItems(id);
        if (item.isPresent()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("ID not found");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItem(@PathVariable int id) {
        Optional<Jobs> data = obj.getItem(id);
        if (data.isPresent()) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("job with id "+id+" Not found");
    }
    
}
