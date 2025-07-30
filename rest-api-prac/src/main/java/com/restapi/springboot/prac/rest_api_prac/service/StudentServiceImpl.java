package com.restapi.springboot.prac.rest_api_prac.service;


import com.restapi.springboot.prac.rest_api_prac.dao.StudentDataRepository;
import com.restapi.springboot.prac.rest_api_prac.entity.StudentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentDataService {

    @Autowired
    private StudentDataRepository studentDataRepository;

    @Autowired
    public StudentServiceImpl(StudentDataRepository studentDataRepository) {
        this.studentDataRepository = studentDataRepository;
    }


    @Override
    public List<StudentData> findAll() {
        return studentDataRepository.findAll();
    }

    @Override
    public Optional<StudentData> findById(Integer theStudentId) {
        Optional<Optional<StudentData>> result = Optional.ofNullable(studentDataRepository.findById(theStudentId));
        Optional<StudentData> theStudent = null;
        if(result.isPresent()){
            theStudent = result.get();
        } else {
            throw new RuntimeException("Not Found Id: "+ theStudent);
        }
        return theStudent;
    }

//    @Override
//    public StudentData createStudent(StudentData theStudentId) {
//        return studentDataRepository.createStudent(theStudentId);
//    }


//    @Override
//    public StudentData save(StudentData theId) {
//        return studentDataRepository.save(theId);
//    }

    @Override
    public void deleteById(Integer theIdStudent) {
//         return studentDataRepository.deleteById(theIdStudent);
    }

    @Override
    public StudentData saveStudent(StudentData theStudent) {
        theStudent.setId(null);
        return studentDataRepository.save(theStudent);
    }

    @Override
    public StudentData updateStudent(int id, StudentData student) {
        Optional<StudentData> optionalStudentData = studentDataRepository.findById(id);
        if(optionalStudentData.isPresent()){
            StudentData existing = optionalStudentData.get();
            if(student.getEmail() != null){
                existing.setEmail(student.getEmail());
            }
            if(student.getSalary() != null) {
                existing.setSalary(student.getSalary());
            }
            if(student.getJobTitle() != null){
                existing.setJobTitle(student.getJobTitle());
            }
            if(student.getHireDate() != null) {
                existing.setHireDate(student.getHireDate());
            }
            if(student.getFirstName() !=null) {
                existing.setFirstName(student.getFirstName());
            }
            if(student.getLastName() != null){
                existing.setLastName(student.getLastName());
            }
            if(student.getMobileNumber() != null){
                existing.setMobileNumber(student.getMobileNumber());
            }
            return studentDataRepository.save(existing);
        }
        else {
            throw new RuntimeException("Student with ID " + id + " not found");
        }
    }


}
