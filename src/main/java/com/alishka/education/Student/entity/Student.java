package com.alishka.education.Student.entity;

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

    @ManyToOne(fetch=FetchType.EAGER, optional = false )
    private Scholarship Scholarship;

    private String Password;

    private Integer Age;

    private String Email;

    private String Major;

    private String Faculty;

    private Integer GPA;

    private String Timeframe;

    public Scholarship getScholarship() {
        return Scholarship;
    }

    public Student setScholarship(Scholarship scholarship) {
        Scholarship = scholarship;
        return this;
    }

    public String getMajor() {
        return Major;
    }

    public Student setMajor(String major) {
        Major = major;
        return this;
    }

    public String getFaculty() {
        return Faculty;
    }

    public Student setFaculty(String faculty) {
        Faculty = faculty;
        return this;
    }

    public Integer getGPA() {
        return GPA;
    }

    public Student setGPA(Integer GPA) {
        this.GPA = GPA;
        return this;
    }

    public String getTimeframe() {
        return Timeframe;
    }

    public Student setTimeframe(String timeframe) {
        Timeframe = timeframe;
        return this;
    }

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
