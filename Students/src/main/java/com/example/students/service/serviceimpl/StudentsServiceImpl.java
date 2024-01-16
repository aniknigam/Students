package com.example.students.service.serviceimpl;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.students.entity.Students;
import com.example.students.exception.ResourceNotFoundException;
import com.example.students.payloads.StudentsDTO;
import com.example.students.repository.StudentsRepo;
import com.example.students.service.StudentsService;

@Service
public class StudentsServiceImpl implements StudentsService {
	
    @Autowired
	private StudentsRepo studentsrepo;
    
    @Autowired
    private ModelMapper modelMapper;

	@Override
	public StudentsDTO createStudent(StudentsDTO student) {
		Students newstudent =  this.modelMapper.map(student, Students.class);
		Students savestudent = this.studentsrepo.save(newstudent);
		StudentsDTO studentdto = this.modelMapper.map(savestudent, StudentsDTO.class);
		return studentdto;
	}

	@Override
	public StudentsDTO updateStudent(StudentsDTO student, Integer id) {
		 Students updateStudent = this.studentsrepo.findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		 updateStudent.setStudentName(student.getStudentName());
		 updateStudent.setAge(student.getAge());
		 updateStudent.setCourse(student.getCourse());
		 updateStudent.setRollNumber(student.getRollNumber());
		 
		 Students saveupdatedstudent = this.studentsrepo.save(updateStudent);
		 StudentsDTO studentdto = this.modelMapper.map(saveupdatedstudent, StudentsDTO.class);
		return studentdto;
	}

	@Override
	public StudentsDTO getStudentById(Integer id) {
		 Students student = this.studentsrepo.findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		 
		 StudentsDTO studentdto = this.modelMapper.map(student, StudentsDTO.class);
		return studentdto;
	}

	@Override
	public List<StudentsDTO> getAllStudents() {
		List<Students> allstudents = this.studentsrepo.findAll();
		List<StudentsDTO> allstudentsdto = allstudents
				.stream().map((st) -> this.modelMapper.map(st, StudentsDTO.class))
				.collect(Collectors.toList());
		return allstudentsdto;
	}

	@Override
	public void deleteStudent(Integer id) {
		 Students student = this.studentsrepo.findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		 this.studentsrepo.delete(student);

	}

}
