package com.alishka.education.Student.repo;

import com.alishka.education.Student.entity.Student;
import com.alishka.education.StudentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataStudentRepo extends JpaRepository<Student, Integer> {

}
