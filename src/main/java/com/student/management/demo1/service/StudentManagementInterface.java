package com.student.management.demo1.service;

import com.student.management.demo1.model.Student;

import java.util.List;

public interface StudentManagementInterface {

    Student getStudentById(Integer Id);
    List<Student> getAllStudents();
    Student addStudents(Student student);
    Student editStudent(Student student,Integer Id);
    String deleteStudent(Integer Id);

}