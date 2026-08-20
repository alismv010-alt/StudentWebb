package com.alishka.education.Student.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="scholarship")
public class Scholarship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Integer amount;

    @OneToMany (mappedBy = "Scholarship", targetEntity = Student.class, cascade = CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval = true)
    private List<Student> students;

    public Integer getId() {
        return id;
    }

    public Scholarship setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Scholarship setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public Scholarship setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }
}
