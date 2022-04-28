package com.hasim.restful_phase_ii.repository;


import com.hasim.restful_phase_ii.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static ArrayList<Student> students = new ArrayList<>();

    public List<Student> GetAll() {
        return students;
    }

    public Student GetByStudentID(int id) {
        //return students.stream().filter(x -> x.getId() == id)
        return students.stream().filter(x -> x.getId() == id).findAny()
                .orElse(null);
    }

    public void insert(Student pStudent) {
        students.add(pStudent);
    }


    public List<Student> getStudentsByMajor(String major) {
        return students.stream().filter(x->x.getMajor() == major).collect(Collectors.toList());
    }


}