package com.alishka.education.Student.controllers;

import com.alishka.education.Student.DTO.ScholarshipDTO;
import com.alishka.education.Student.DTO.StudentDTO;
import com.alishka.education.Student.DTO.UniversityDTO;
import com.alishka.education.Student.entity.Scholarship;
import com.alishka.education.Student.entity.University;
import com.alishka.education.Student.repo.DataStudentRepo;
import com.alishka.education.Student.entity.Student;
import com.alishka.education.Student.repo.StudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<StudentDTO> getList (@RequestParam(required = false) String name,
                                  @RequestParam(required = false) String surname,
                                  @RequestParam(required = false) String email,
                                  @RequestParam(required = false) String password,
                                  @RequestParam(required = false) Integer university_id,
                                  @RequestParam(required = false) Integer age) {
        return studentRepo.getList(name, surname, email, password, university_id, age)
                .stream()
                .map(StudentController::toStudnetDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void save (@RequestBody StudentDTO studentDTO) {
        datarepo.save(toStudnetEntity(studentDTO));
    }

    @PutMapping
    public void update (@RequestBody StudentDTO studentDTO) {
        datarepo.save(toStudnetEntity(studentDTO));
    }

    @DeleteMapping
    public void delete (@RequestParam Integer id) {
        datarepo.deleteById(id);
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentByID(@PathVariable Integer id) {
        return datarepo.findById(id).map(StudentController::toStudnetDTO).orElse(new StudentDTO());
    }

    private static StudentDTO toStudnetDTO (Student studentEntity) {
        return new StudentDTO()
                .setID(studentEntity.getID())
                .setName(studentEntity.getName())
                .setSurname(studentEntity.getSurname())
                .setAge(studentEntity.getAge())
                .setEmail(studentEntity.getEmail())
                .setGPA(studentEntity.getGPA())
                .setMajor(studentEntity.getMajor())
                .setFaculty(studentEntity.getFaculty())
                .setTimeframe(studentEntity.getTimeframe())
                .setScholarship(
                        new ScholarshipDTO()
                                .setId(studentEntity.getScholarship().getId())
                                .setName(studentEntity.getScholarship().getName())
                                .setAmount(studentEntity.getScholarship().getAmount())
                )
                .setUniversity(
                        new UniversityDTO()
                                .setId(studentEntity.getUniversity().getId())
                                .setName(studentEntity.getUniversity().getName())
                );

    }
    private static Student toStudnetEntity (StudentDTO studentDTO) {
        return new Student()
                .setID(studentDTO.getID())
                .setName(studentDTO.getName())
                .setSurname(studentDTO.getSurname())
                .setAge(studentDTO.getAge())
                .setEmail(studentDTO.getEmail())
                .setGPA(studentDTO.getGPA())
                .setMajor(studentDTO.getMajor())
                .setFaculty(studentDTO.getFaculty())
                .setTimeframe(studentDTO.getTimeframe())
                .setScholarship(
                        new Scholarship()
                                .setId(studentDTO.getScholarship().getId())
                                .setName(studentDTO.getScholarship().getName())
                                .setAmount(studentDTO.getScholarship().getAmount())
                )
                .setUniversity(
                        new University()
                                .setId(studentDTO.getUniversity().getId())
                                .setName(studentDTO.getUniversity().getName())
                );

    }
}
