package com.chandu.service.impl;

import com.chandu.dao.StudentDao;

import com.chandu.model.Student;
import com.chandu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    StudentDao studentDao;

    @Override
    public void insertStudent(Student std) {
        studentDao.insertStudent(std);

    }

    @Override
    public void insertStudents(List<Student> students) {
    studentDao.insertStudents(students);
    }

    @Override
    public void getAllStudent() {
        List<Student> students = studentDao.getAllStudents();
        for (Student student : students) {
            System.out.println(student.toString());
        }

    }

    @Override
    public void getStudentById(String stdId) {
        Student student = studentDao.getStudentById(stdId);
        System.out.println(student);
    }
}
