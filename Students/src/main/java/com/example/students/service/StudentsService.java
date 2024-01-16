package com.example.students.service;

import java.util.List;


import com.example.students.payloads.StudentsDTO;

public interface StudentsService {
    StudentsDTO createStudent(StudentsDTO student);
	
    StudentsDTO updateStudent(StudentsDTO student, Integer id );
	
    StudentsDTO getStudentById(Integer id);
	
	List<StudentsDTO> getAllStudents();
	
	void deleteStudent(Integer id);
}
