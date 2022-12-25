package com.study.springboot202210;

import com.study.springboot202210.locAndDi.Student;
import com.study.springboot202210.locAndDi.StudentService;
import org.springframework.stereotype.Component;


@Component
public class StudentServiceImpl implements StudentService {

    @Override
    public void printStudentInfo(Student student) {
        System.out.println("학번 : " + student.getStudentId());
        System.out.println("학번 : " + student.getStudentName());
    }
}
