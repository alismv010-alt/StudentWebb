package com.alishka.education;

import com.alishka.education.Student.entity.Student;
import com.alishka.education.Student.repo.StudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {
    private final MyDataStudentRepo datarepo;
    private final StudentRepo studentRepo;

    public StudentController (final MyDataStudentRepo datarepo, StudentRepo studentRepo) {
        this.datarepo=datarepo;
        this.studentRepo = studentRepo;
    }
    @GetMapping
    public List<Student> getList () {
        return datarepo.findAll();
    }

    @PostMapping
    public void save (Student student) {
                datarepo.save(student);
    }

    @DeleteMapping
    public void delete (@RequestParam Integer id) {
        datarepo.deleteById(id);
    }
}
