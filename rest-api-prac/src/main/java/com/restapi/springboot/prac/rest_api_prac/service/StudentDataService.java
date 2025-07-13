package com.restapi.springboot.prac.rest_api_prac.service;

import com.restapi.springboot.prac.rest_api_prac.entity.StudentData;

import java.util.List;
import java.util.Optional;

public interface StudentDataService {
    List<StudentData> findAll();
    Optional<StudentData> findById(Integer theStudentId);

    void deleteById(Integer theIdStudent);

    StudentData saveStudent(StudentData theStudent);
    StudentData updateStudent(int id,StudentData student);
}
