package com.example.students.payloads;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentsDTO {

    private int id;
    
    @NotBlank(message = "Student name cannot be blank")
   	private String studentName;
    
   
   	private int age;      
    
    @NotBlank(message = "Roll Number cannot be blank")
   	private String rollNumber;
    
    @NotBlank(message = "Course cannot be blank")
   	private String course;  
}
