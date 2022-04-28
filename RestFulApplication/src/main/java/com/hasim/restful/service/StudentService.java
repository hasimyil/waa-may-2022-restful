package com.hasim.restful.service;

import com.hasim.restful.model.Course;
import com.hasim.restful.model.Product;
import com.hasim.restful.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> GetAll();

    boolean save(Student p);

    Student getById(int id);

    List<Student> getStudentsByMajor(String major);


}
