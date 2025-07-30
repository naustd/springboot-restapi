package com.restapi.springboot.prac.rest_api_prac.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.springboot.prac.rest_api_prac.entity.StudentData;
import com.restapi.springboot.prac.rest_api_prac.service.StudentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private final StudentDataService studentDataService;
    private final ObjectMapper objectMapper;

    @Autowired
    public StudentRestController(StudentDataService studentDataService, ObjectMapper objectMapper) {
        this.studentDataService = studentDataService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/students")
    public ResponseEntity<Map<String, Object>> findAll() {
        List<StudentData> students = studentDataService.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("message", students.isEmpty() ? "No students found" : "Successfully retrieved all students");
        response.put("data", students);
        response.put("status", HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<Map<String, Object>> getStudentData(@PathVariable int studentId) {
        Optional<StudentData> studentData = studentDataService.findById(studentId);

        Map<String, Object> response = new HashMap<>();

        if (studentData.isEmpty()) {
            response.put("message", "Student not found with ID: " + studentId);
            response.put("status", HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        response.put("message", "Successfully retrieved student with ID: " + studentId);
        response.put("data", studentData.get());
        response.put("status", HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable int studentId) {
        Optional<StudentData> student = studentDataService.findById(studentId);
        Map<String, Object> response = new HashMap<>();

        if (student.isEmpty()) {
            response.put("message", "Student not found with ID: " + studentId);
            response.put("status", HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        studentDataService.deleteById(studentId);
        response.put("message", "Successfully deleted student with ID: " + studentId);
        response.put("status", HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/students")
    public ResponseEntity<Map<String, Object>> createStudent(@RequestBody StudentData student) {
        StudentData savedStudent = studentDataService.saveStudent(student);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Student created successfully");
        response.put("data", savedStudent);
        response.put("status", HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Map<String, Object>> updateStudent(@PathVariable int id, @RequestBody StudentData studentData) {
        Optional<StudentData> existingStudent = studentDataService.findById(id);
        Map<String, Object> response = new HashMap<>();

        if (existingStudent.isEmpty()) {
            response.put("message", "Student not found with ID: " + id);
            response.put("status", HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        StudentData updatedStudent = studentDataService.updateStudent(id, studentData);
        response.put("message", "Successfully updated student with ID: " + id);
        response.put("data", updatedStudent);
        response.put("status", HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

}