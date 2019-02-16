package com.broada.service;

import com.broada.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentService extends JpaRepository<Student,Integer> {
    Student findBySid(Integer sid);
}
