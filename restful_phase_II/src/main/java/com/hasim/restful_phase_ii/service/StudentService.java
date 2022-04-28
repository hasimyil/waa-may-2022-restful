package com.hasim.restful_phase_ii.service;


import com.hasim.restful_phase_ii.dto.StudentDto;
import com.hasim.restful_phase_ii.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> GetAll();

    boolean save(Student p);

    StudentDto getById(int id);

    List<Student> getStudentsByMajor(String major);


}
