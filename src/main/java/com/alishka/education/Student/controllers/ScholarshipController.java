package com.alishka.education.Student.controllers;

import com.alishka.education.Student.entity.Scholarship;
import com.alishka.education.Student.repo.DataScholarshipRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scholarships")
@CrossOrigin()
public class ScholarshipController {
    private final DataScholarshipRepo datarepo;

    public ScholarshipController(DataScholarshipRepo datarepo) {
        this.datarepo = datarepo;
    }

    @GetMapping
    public List<Scholarship> getScholarships () {
        return datarepo.findAll();
    }
}
