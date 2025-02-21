package com.alex.springapp.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

import com.alex.springapp.entity.Company;
import com.alex.springapp.service.CompanyService;

@Controller
public class CompanyController {
    @Autowired
    CompanyService obj;

    @GetMapping("api/Companys/get")
    public ResponseEntity<List<Company>> getAllCompanys() {
        return new ResponseEntity<>(obj.getAllCompanys(), HttpStatus.OK);
    }
    @PostMapping("api/Companys/post")
    public ResponseEntity<Company> postCompany(@RequestBody Company mess) {
        return new ResponseEntity<>(obj.postCompany(mess), HttpStatus.OK);
    }
    @PutMapping("/api/Companys/update/{id}")
    public ResponseEntity<Company> updateCompany(@RequestBody Company mess, @PathVariable int id) {
        return new ResponseEntity<>(obj.updateDetails(mess, id), HttpStatus.OK);

    }
    
    @DeleteMapping("/api/Companys/delete/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable int id) {
        Optional<Company> item = obj.deleteCompany(id);
        if (item.isPresent()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        Map<String, String> response = new LinkedHashMap<>();
        response.put("Success", "false");
        response.put("Message", "id not found");
        return ResponseEntity.status(404).body(response);
    }

    @GetMapping("/api/Companys/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        Optional<Company> item = obj.getUser(id);
        if (item.isPresent()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("Id not found");
    }

    @GetMapping("/api/company/pagination/{size}/{PageNo}")
    public ResponseEntity<?> getByPage(@PathVariable int PageNo, @PathVariable int size) {
        List<Company> item = obj.getCompanyByPage(PageNo, size);
        if (!item.isEmpty()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("No items present");
    }

    @GetMapping("/company/sortBy/{field}")
    public ResponseEntity<List<Company>> getSored(@PathVariable String field)
    {
        return new ResponseEntity<>(obj.sorted(field), HttpStatus.OK);
    }

}
