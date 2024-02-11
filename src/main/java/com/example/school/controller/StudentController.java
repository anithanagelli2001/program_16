/*
 *
 * You can use the following import statemets
 *
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */
package com.example.school.controller;

import com.example.school.service.StudentH2Service;
import com.example.school.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class StudentController {

    @Autowired
    private StudentH2Service studentService;

    @GetMapping("/students")
    public ArrayList<Student> getAllStudents() {

        return studentService.getAllStudents();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int studentId) {

        return studentService.getStudentById(studentId);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student school) {

        return studentService.addStudent(school);
    }

    @PostMapping("/students/bulk")

    public String addMultipleStudents(@RequestBody ArrayList<Student> studentsList) {

        return studentService.addMultipleStudents(studentsList);
    }

    @PutMapping("/students/{studentId}")
    public Student updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student school) {

        return studentService.updateStudent(studentId, school);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable("studentId") int studentId) {

        studentService.deleteStudent(studentId);
    }
}