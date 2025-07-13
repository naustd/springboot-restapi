package com.restapi.springboot.prac.rest_api_prac.service;


import com.restapi.springboot.prac.rest_api_prac.dao.StudentDataRepository;
import com.restapi.springboot.prac.rest_api_prac.entity.StudentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            existing.setEmail(student.getEmail());
            existing.setSalary(student.getSalary());
            existing.setJobTitle(student.getJobTitle());
            existing.setHireDate(student.getHireDate());
            existing.setFirstName(student.getFirstName());
            existing.setLastName(student.getLastName());
            existing.setMobileNumber(student.getMobileNumber());
            return studentDataRepository.save(existing);
        }
        else {
            throw new RuntimeException("Student with ID " + id + " not found");
        }
    }


}
