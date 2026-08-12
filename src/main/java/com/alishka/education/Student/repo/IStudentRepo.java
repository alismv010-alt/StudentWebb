package com.alishka.education.Student.repo;

import com.alishka.education.Student.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public interface IStudentRepo {

    public List<Student> getList();

    public void update(Integer id);


    public void delete(Integer id);

    public void insert(Integer id);

    public List<Student> getList(String name, String surname, String email, String password,
                                 Integer university, Integer age );
}
