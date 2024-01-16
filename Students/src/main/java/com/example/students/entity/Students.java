package com.example.students.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
    @NotBlank(message = "Student name cannot be blank")
   	private String studentName;
    
 
    
   	private int age;      
    
    @NotBlank(message = "Roll Number cannot be blank")
   	private String rollNumber;
    
    @NotBlank(message = "Course cannot be blank")
   	private String course;    
    
}
