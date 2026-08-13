package com.alishka.education.Student.entity;

import com.alishka.education.StudentProjection;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity(name="MyStudent")
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private String Name;

    private String Surname;

    @ManyToOne(fetch=FetchType.EAGER, optional = false )
    private University University;

    private String Password;

    private Integer Age;

    private String Email;

    public String getName() {
        return Name;
    }

    public Student setName(String Name) {
        this.Name = Name;
        return this;
    }

    public String getSurname() {
        return Surname;
    }

    public Student setSurname(String Surname) {
        this.Surname = Surname;
        return this;
    }

    public Integer getID() {
        return ID;
    }

    public Student setID(Integer ID) {
        this.ID = ID;
        return this;
    }

    public University getUniversity() {
        return University;
    }

    public Student setUniversity(University University) {
        this.University = University;
        return this;
    }

    public String getPassword() {
        return Password;
    }

    public Student setPassword(String Password) {
        this.Password = Password;
        return this;
    }

    public Integer getAge() {
        return Age;
    }

    public Student setAge(Integer Age) {
        this.Age = Age;
        return this;
    }

    public String getEmail() {
        return Email;
    }

    public Student setEmail(String Email) {
        this.Email = Email;
        return this;
    }
}
