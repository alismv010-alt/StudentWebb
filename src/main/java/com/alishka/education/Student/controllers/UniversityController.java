package com.alishka.education.Student.controllers;


import com.alishka.education.Student.entity.Student;
import com.alishka.education.Student.entity.University;
import com.alishka.education.Student.repo.DataStudentRepo;
import com.alishka.education.Student.repo.DataUniversityRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/universities")
@CrossOrigin(origins = "localhost:9090/education/students.html")
public class UniversityController {
    private final DataUniversityRepo datarepo;

    public UniversityController(DataUniversityRepo datarepo) {
        this.datarepo = datarepo;
    }

    @GetMapping
    public List<University> getUniversities () {
        return datarepo.findAll();
    }
}
