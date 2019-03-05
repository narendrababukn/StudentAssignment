package com.chandu.Contoller;

import com.chandu.model.Student;
import com.chandu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController
{
    @Autowired
    StudentService studentService;

    @RequestMapping("/addStudent")
    public String addStudent(Student student)
    {
        studentService.
    }

    @GetMapping("/")
    public void getData(Student student)
    {
        Student s=new Student();

    }
}
