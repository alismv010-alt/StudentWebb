package com.alishka.education.Student.DTO;

public class StudentDTO {
    private Integer ID;

    private String Name;

    private String Surname;

    private Integer Age;

    private String Email;

    private String Major;

    private String Faculty;

    private Integer GPA;

    private String Timeframe;

    private UniversityDTO University;

    private ScholarshipDTO Scholarship;

    public Integer getID() {
        return ID;
    }

    public StudentDTO setID(Integer ID) {
        this.ID = ID;
        return this;
    }

    public String getName() {
        return Name;
    }

    public StudentDTO setName(String name) {
        Name = name;
        return this;
    }

    public String getSurname() {
        return Surname;
    }

    public StudentDTO setSurname(String surname) {
        Surname = surname;
        return this;
    }

    public Integer getAge() {
        return Age;
    }

    public StudentDTO setAge(Integer age) {
        Age = age;
        return this;
    }

    public String getMajor() {
        return Major;
    }

    public StudentDTO setMajor(String major) {
        Major = major;
        return this;
    }

    public String getEmail() {
        return Email;
    }

    public StudentDTO setEmail(String email) {
        Email = email;
        return this;
    }

    public String getFaculty() {
        return Faculty;
    }

    public StudentDTO setFaculty(String faculty) {
        Faculty = faculty;
        return this;
    }

    public Integer getGPA() {
        return GPA;
    }

    public StudentDTO setGPA(Integer GPA) {
        this.GPA = GPA;
        return this;
    }

    public String getTimeframe() {
        return Timeframe;
    }

    public StudentDTO setTimeframe(String timeframe) {
        Timeframe = timeframe;
        return this;
    }

    public ScholarshipDTO getScholarship() {
        return Scholarship;
    }

    public StudentDTO setScholarship(ScholarshipDTO scholarship) {
        Scholarship = scholarship;
        return this;
    }

    public UniversityDTO getUniversity() {
        return University;
    }

    public StudentDTO setUniversity(UniversityDTO university) {
        University = university;
        return this;
    }
}
