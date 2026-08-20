package com.alishka.education.Student.DTO;

public class ScholarshipDTO {
    Integer id;

    String name;

    Integer amount;

    public Integer getId() {
        return id;
    }

    public ScholarshipDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ScholarshipDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public ScholarshipDTO setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }
}
