package com.chandu.service;

import com.chandu.model.Student;

import java.util.List;

public interface StudentService
{
    void insertStudent(Student std);
    void insertStudents(List<Student> students);
    void getAllStudent();
    void getStudentById(String stdId);
}
