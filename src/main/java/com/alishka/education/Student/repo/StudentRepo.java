package com.alishka.education.Student.repo;

import com.alishka.education.Student.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentRepo implements IStudentRepo {

    private final EntityManager em;


    public StudentRepo (EntityManager em) {
        this.em=em;
    }
    public List<Student> getList() {
        final Query nativequery = em.createNativeQuery("Select * from student", Student.class);
        return nativequery.getResultList();
    }


    public void update(Integer id) {
    }

    @Transactional
    public void delete(Integer id) {
        final Student t = em.find(Student.class, id);
        em.remove(t);
    }

    public void insert(Integer id) {

    }

    public Student findByID(Integer id) {
        return null;
    }
    public List<Student> getList(String name, String surname, String email, String password,
                                 String university, Integer age ) {
        return null;
    }
}
