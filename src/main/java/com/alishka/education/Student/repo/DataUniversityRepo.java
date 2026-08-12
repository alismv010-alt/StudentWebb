package com.alishka.education.Student.repo;

import com.alishka.education.Student.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataUniversityRepo extends JpaRepository<University, Integer> {
}
