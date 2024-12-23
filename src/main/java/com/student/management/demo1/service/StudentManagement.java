package com.student.management.demo1.service;

import com.student.management.demo1.model.Student;
import com.student.management.demo1.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentManagement implements StudentManagementInterface {

    private final StudentRepository studentRepository;

    StudentManagement(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public Student getStudentById(Integer Id) {
        return studentRepository.findById(Id).get();
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }
    public Student addStudents(Student student){
        return studentRepository.save(student);
    }
    @Override
    public Student editStudent(Student student,Integer Id){

        Student existingStudent=studentRepository.findById(Id).get();

        existingStudent.setDepartment(student.getDepartment() != null ? student.getDepartment() : existingStudent.getDepartment());
        existingStudent.setName(student.getName() != null ? student.getName() : existingStudent.getName());
        existingStudent.setYear(student.getYear() != null ? student.getYear() : existingStudent.getYear());

        return studentRepository.save(existingStudent);

    }
    @Override
    public String deleteStudent(Integer Id){
        studentRepository.deleteById(Id);
        return "data deleted successfully";

    }
}
