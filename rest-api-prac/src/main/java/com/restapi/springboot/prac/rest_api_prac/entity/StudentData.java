package com.restapi.springboot.prac.rest_api_prac.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "studentrecords")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "phone_number")
    private String mobileNumber;
    @Column(name = "hire_date",columnDefinition = "DATE")
    private LocalDate hireDate;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(precision = 10,scale = 2, nullable = false)
    private BigDecimal salary;
}
