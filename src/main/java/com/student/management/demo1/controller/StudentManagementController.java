package com.student.management.demo1.controller;
import com.student.management.demo1.model.Student;
import com.student.management.demo1.service.StudentManagementInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/a1")
public class StudentManagementController {
    private final StudentManagementInterface studentManagementInterface;
    StudentManagementController(StudentManagementInterface studentManagementInterface) {
        this.studentManagementInterface = studentManagementInterface;
    }

    @GetMapping({"/student/{id}"})
    public Student getStudentById(@PathVariable Integer id){
        return studentManagementInterface.getStudentById(id);
    }

    @GetMapping({"/student"})
    public List<Student> getAllStudents(){
        return studentManagementInterface.getAllStudents();
    }

    @PostMapping({"/student"})
    public Student addStudent(@RequestBody Student student){
        return studentManagementInterface.addStudents(student);
    }

    @PutMapping({"/student/{id}"})
    public Student editStudent(@RequestBody Student student,@PathVariable Integer id){
        return studentManagementInterface.editStudent(student,id);
    }
    @DeleteMapping({"/student/{id}"})
    public String deleteStudent(@PathVariable Integer id){
        return studentManagementInterface.deleteStudent(id);
    }
}
