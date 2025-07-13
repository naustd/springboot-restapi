package com.restapi.springboot.prac.rest_api_prac.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.restapi.springboot.prac.rest_api_prac.entity.StudentData;
import com.restapi.springboot.prac.rest_api_prac.service.StudentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private final StudentDataService studentDataService;
    private ObjectMapper objectMapper;
    @Autowired
    public StudentRestController(StudentDataService studentDataService,ObjectMapper objectMapper) {
        this.studentDataService = studentDataService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/students")
    public List<StudentData> findAll() {
        return studentDataService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<Optional<StudentData>> getStudentData(@PathVariable int studentId) {
        Optional<Optional<StudentData>> theStudentData = Optional.ofNullable(studentDataService.findById(studentId));

        if (theStudentData.isEmpty()) {
            return ResponseEntity.notFound().build();  // 404 Not Found
        }

        return ResponseEntity.ok(theStudentData.get());  // 200 OK with body
    }



    @DeleteMapping("/students/{studentId}")
    public String deleteEmployee(@PathVariable int studentId){
        Optional<Optional<StudentData>> tempStudent = Optional.ofNullable(studentDataService.findById(studentId));
        if(tempStudent == null) {
            throw new RuntimeException("Employee id -"+ studentId);
        }
        studentDataService.deleteById(studentId);
        return "Deleted -" + studentId;
    }

    @PostMapping("/student")
    public StudentData createStudent(@RequestBody  StudentData student){
        return studentDataService.saveStudent(student);
    }
    @PutMapping("/{id}")
    public StudentData updateStudent(@PathVariable int id,@RequestBody StudentData studentData){
        return studentDataService.updateStudent(id, studentData);
    }
}
