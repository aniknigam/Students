package com.example.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.students.entity.Students;

public interface StudentsRepo extends JpaRepository<Students, Integer> {

}
