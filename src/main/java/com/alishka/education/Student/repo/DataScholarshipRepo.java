package com.alishka.education.Student.repo;

import com.alishka.education.Student.entity.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataScholarshipRepo extends JpaRepository<Scholarship,Integer> {
}
