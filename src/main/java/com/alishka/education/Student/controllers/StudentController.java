package com.alishka.education.Student.controllers;

import com.alishka.education.Student.repo.DataStudentRepo;
import com.alishka.education.Student.entity.Student;
import com.alishka.education.Student.repo.StudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "localhost:9090/education/students.html")
public class StudentController {
    private final DataStudentRepo datarepo;
    private final StudentRepo studentRepo;

    public StudentController (final DataStudentRepo datarepo, StudentRepo studentRepo) {
        this.datarepo=datarepo;
        this.studentRepo = studentRepo;
    }
    @GetMapping
    public List<Student> getList (@RequestParam(required = false) String name,
                                  @RequestParam(required = false) String surname,
                                  @RequestParam(required = false) String email,
                                  @RequestParam(required = false) String password,
                                  @RequestParam(required = false) Integer university_id,
                                  @RequestParam(required = false) Integer age) {
        return studentRepo.getList(name, surname, email, password, university_id, age);
    }

    @PostMapping
    public void save (@RequestBody Student student) {
        datarepo.save(student);
    }

    @PutMapping
    public void update (@RequestBody Student student) {
        datarepo.save(student);
    }

    @DeleteMapping
    public void delete (@RequestParam Integer id) {
        datarepo.deleteById(id);
    }
}
