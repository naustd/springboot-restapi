package com.restapi.springboot.prac.rest_api_prac.dao;


import com.restapi.springboot.prac.rest_api_prac.entity.StudentData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDataRepository extends JpaRepository<StudentData,Integer> {



}
