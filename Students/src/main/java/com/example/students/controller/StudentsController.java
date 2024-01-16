package com.example.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.students.payloads.ApiResponse;
import com.example.students.payloads.StudentsDTO;
import com.example.students.service.StudentsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentsService studentservice;

	@PostMapping("/create")
	public ResponseEntity<StudentsDTO> createStudent(@Valid @RequestBody StudentsDTO student) {
		StudentsDTO newstudent = this.studentservice.createStudent(student);
		return new ResponseEntity<>(newstudent, HttpStatus.CREATED);
	}

	@PutMapping("/updatestudent/{id}")
	public ResponseEntity<StudentsDTO> updateStudent(@Valid @RequestBody StudentsDTO student,
			@PathVariable Integer id) {
		StudentsDTO updatedstudent = this.studentservice.updateStudent(student, id);
		return ResponseEntity.ok(updatedstudent);
	}

	@GetMapping("/getstudentbyid/{id}")
	public ResponseEntity<StudentsDTO> getStudentById(@PathVariable Integer id) {
		StudentsDTO getStudent = this.studentservice.getStudentById(id);
		return ResponseEntity.ok(getStudent);
	}

	@GetMapping("/allstudents")
	public ResponseEntity<List<StudentsDTO>> getAllStudents() {
		return ResponseEntity.ok(this.studentservice.getAllStudents());
	}

	@DeleteMapping("/deletestudent/{id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer id) {
         this.studentservice.deleteStudent(id);
         return new ResponseEntity<ApiResponse>(new ApiResponse("Student is deleted successfully", true),
 				HttpStatus.OK);
         
	}
}
