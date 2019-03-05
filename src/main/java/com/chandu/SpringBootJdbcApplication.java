package com.chandu;


import com.chandu.model.Student;

import com.chandu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootJdbcApplication {

	@Autowired
	StudentService studentService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);
		StudentService studentService= context.getBean(StudentService.class);


		Student std = new Student();
		std.setStdId("5");
		std.setStdName("Chandu");

		Student std1 = new Student();
		std1.setStdId("6");
		std1.setStdName("Sreekar");

		Student std2 = new Student();
		std2.setStdId("7");
		std2.setStdName("Gnanu");


		studentService.insertStudent(std);

		List<Student> students = new ArrayList<>();
		students.add(std1);
		students.add(std2);
		studentService.insertStudents(students);

		studentService.getAllStudent();

		studentService.getStudentById(std1.getStdId());

	}
}