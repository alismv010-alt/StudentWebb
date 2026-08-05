package com.alishka.education;

import com.alishka.education.Student.entity.Student;
import com.alishka.education.Student.repo.StudentRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final MyDataStudentRepo datarepo;

    public StudentController (final MyDataStudentRepo datarepo ) {
        this.datarepo=datarepo;
    }
    @GetMapping
    public List<Student> getList () {
        return datarepo.findAll();
    }

    @PostMapping
    public void save (Student student) {
                datarepo.save(student);
    }
}
