package com.hasim.restful_phase_ii.dto;


import com.hasim.restful_phase_ii.model.Course;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;
}
