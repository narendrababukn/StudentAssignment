package com.chandu.dao;

import com.chandu.model.Student;

import java.util.List;

public interface StudentDao {
    void insertStudent(Student std);
    void insertStudents(List<Student> employees);
    List<Student> getAllStudents();
    Student getStudentById(String empId);
}
