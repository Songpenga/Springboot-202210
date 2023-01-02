package com.study.springboot202210.repository;

import com.study.springboot202210.web.dto.EmpDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeRepository {

    public int saveEmployee(EmpDto empDto);
}
