package com.alishka.education.Student.repo;

import com.alishka.education.Student.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    public List<Student> getList(String name, String surname, String email, String password,
                                 Integer university_id, Integer age ) {

        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);

        List<Predicate> predicates = new ArrayList();
        if (name!=null && !name.isEmpty()) {
            predicates.add(cb.like(root.get("Name"),"%" + name + "%" ));
        }
        if (surname!=null && !surname.isEmpty()) {
            predicates.add(cb.like(root.get("Surname"),"%" + surname + "%" ));
        }
        if (email!=null && !email.isEmpty()) {
            predicates.add(cb.like(root.get("Email"),"%" + email + "%" ));
        }
        if (password!=null && !password.isEmpty()) {
            predicates.add(cb.like(root.get("Password"),"%" + password + "%" ));
        }
        if (age!=null && age!=0) {
            predicates.add(cb.equal(root.get("Age"), age)); 
        }
        if (university_id!=null && university_id!=0) {
            predicates.add(cb.equal(root.get("University").get("id"), university_id ));
        }

        final Predicate and = cb.and(predicates.toArray(new Predicate[0]));

        cq.where(and);
        cq.select(root);

        return em.createQuery(cq).getResultList();
    }
}
