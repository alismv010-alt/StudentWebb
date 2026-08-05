package com.alishka.education;

import com.alishka.education.Student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyDataStudentRepo extends JpaRepository<Student, Integer> {

    @Query(nativeQuery = true, value ="select *, concat(Name,' ',Surname) as fullname from student ")
    public List<StudentProjection> getAll();
}
