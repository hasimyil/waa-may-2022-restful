package com.hasim.restful.service.impl;

import com.hasim.restful.model.Student;
import com.hasim.restful.repository.StudentRepo;
import com.hasim.restful.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> GetAll() {
        return studentRepo.GetAll();
    }

    @Override
    public boolean save(Student pStudent) {

        if(studentRepo.GetByStudentID(pStudent.getId()) != null){
            return false;
        }else{
            studentRepo.insert(pStudent);
            return true;
        }
    }

    @Override
    public Student getById(int id) {
        return studentRepo.GetByStudentID(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }



}
