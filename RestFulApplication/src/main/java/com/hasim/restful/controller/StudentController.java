package com.hasim.restful.controller;

import com.hasim.restful.model.Course;
import com.hasim.restful.model.Student;
import com.hasim.restful.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;



    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return   ResponseEntity.ok(studentService.GetAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getByStudentId(@PathVariable int id) {
        return   ResponseEntity.ok(studentService.getById(id));

    }
    @RequestMapping("api/v2/students/{id}")
    public ResponseEntity<List<Course>> getCoursesByStudentId(@PathVariable int id) {
        Student st= studentService.getById(id);
        return ResponseEntity.ok(st.getCoursesTaken());

    }

    @RequestMapping("api/v2/students/filter")
    public ResponseEntity<List<Student>> getStudentsByMajor(@RequestParam String major) {
        return   ResponseEntity.ok(studentService.getStudentsByMajor(major));

    }


    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student pStudent) {

        if(studentService.save(pStudent)){
            return ResponseEntity.ok(pStudent);
        }else{
            return ResponseEntity.ok(null);
        }

    }


}
