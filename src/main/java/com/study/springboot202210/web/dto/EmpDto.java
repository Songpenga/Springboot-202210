package com.study.springboot202210.web.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpDto {
    private int emp_id;
    private String empName;
    private int empAge;
    private String empPhone;
}
