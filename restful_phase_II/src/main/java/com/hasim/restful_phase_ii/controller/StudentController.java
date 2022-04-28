package com.hasim.restful_phase_ii.controller;


import com.hasim.restful_phase_ii.dto.StudentDto;
import com.hasim.restful_phase_ii.entity.Student;
import com.hasim.restful_phase_ii.model.Course;
import com.hasim.restful_phase_ii.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;



    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll() {
        return   ResponseEntity.ok(studentService.GetAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getByStudentId(@PathVariable int id) {
        return   ResponseEntity.ok(studentService.getById(id));

    }
    @RequestMapping("api/v2/students/{id}")
    public ResponseEntity<List<Course>> getCoursesByStudentId(@PathVariable int id) {
        StudentDto st= studentService.getById(id);
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
