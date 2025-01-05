package com.example.spring_demo;

import com.example.spring_demo.dao.StudentDAO;
import com.example.spring_demo.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


// adding packages outside the main one
/*
@SpringBootApplication(
		scanBasePackages = {"package_name_1",
							"package_name_2"})
 */
@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {

//		// Print environment variables to verify they are loaded
//		System.out.println("DB_URL: " + System.getenv("DB_URL"));
//		System.out.println("DB_USERNAME: " + System.getenv("DB_USERNAME"));

		SpringApplication.run(SpringDemoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
//		return runner -> {
////			createStudent(studentDAO);
////			readStudent(studentDAO);
////			queryForStudents(studentDAO);
////			queryForStudentsByLastName(studentDAO);
////			updateStudent(studentDAO);
////			deleteStudent(studentDAO);
////			deleteAllStudent(studentDAO);
//		};
//	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all student records.");
		int numRows = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRows);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		System.out.println("Deleting student id: 3");
		studentDAO.delete(3);
	}

	private void updateStudent(StudentDAO studentDAO) {
		System.out.println("Updating student with id: 2");

		Student student = studentDAO.findById(2);
		student.setFirstName("Scooby");
		studentDAO.update(student);
		System.out.println("Updated student: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> studentsList = studentDAO.findByLastName("Doe");

		// display a list of students
		for(Student s: studentsList){
			System.out.println(s);
		}
	}

	private void createStudent(StudentDAO studentDAO){
		System.out.println("Creating new student object.");
		Student tmpStudent = new Student("Paul", "Doe", "paul@gmail.com");

		System.out.println("Saving the student.");
		studentDAO.save(tmpStudent);

		System.out.println("Saved student. Generated ID: " + tmpStudent.getId());
	}

	private void readStudent(StudentDAO studentDAO){
		System.out.println("Retrieve Student with id 2.");
		Student student = studentDAO.findById(2);

		System.out.println("Found student: " + student);
	}

	private void queryForStudents(StudentDAO studentDAO){
		// get a list of students
		List<Student> studentsList = studentDAO.findAll();

		// display a list of students
		for(Student s: studentsList){
			System.out.println(s);
		}
	}

}
