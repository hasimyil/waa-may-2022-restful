package com.hasim.restful_phase_ii.service.impl;


import com.hasim.restful_phase_ii.dto.StudentDto;
import com.hasim.restful_phase_ii.entity.Student;
import com.hasim.restful_phase_ii.repository.StudentRepo;
import com.hasim.restful_phase_ii.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<StudentDto> GetAll() {
        var result = new ArrayList<StudentDto>();
        var list = studentRepo.GetAll();
        list.forEach(item ->{
            StudentDto dto  = new StudentDto();
            dto.setId(item.getId());
            dto.setFirstName(item.getFirstName());
            dto.setLastName(item.getFirstName());
            dto.setEmail(item.getEmail());
            dto.setMajor(item.getMajor());
            result.add(dto);
        });

        return result;
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
    public StudentDto getById(int id) {
        var result = new StudentDto();
        var std = studentRepo.GetByStudentID(id);;
        result.setId(std.getId());
        result.setEmail(std.getEmail());
        result.setMajor(std.getMajor());
        result.setFirstName(std.getFirstName());
        result.setLastName(std.getLastName());
        return result;
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }



}
