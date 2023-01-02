package com.study.springboot202210.service;

import com.study.springboot202210.repository.EmployeeRepository;
import com.study.springboot202210.web.dto.EmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public  int addEmployee(EmpDto empdto) {
        return employeeRepository.saveEmployee(empdto) > 0 ? empdto.getEmp_id() : 0;

    }
}
