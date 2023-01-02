package com.study.springboot202210.web.dto;

import lombok.Data;

@Data //getters, setters
public class RequestStudyDto {
    private String name;
    private String email;
    private String address;

}
