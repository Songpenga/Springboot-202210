package com.study.springboot202210.web.controller;

import com.study.springboot202210.web.dto.RequestStudyDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerStudy {


    @GetMapping("/study/page")
    public String 페이지응답(){
        return "page_study"; //return에 / 붙이지 않기
    }

    @ResponseBody
    @GetMapping("/study/text")
    public String 문자열데이터응답(){
        return "문자열을 응답";
    }
    @ResponseBody
    @GetMapping("/study/text/2")
    public String 요청데이터Params(String data1, int data2) {
        return "문자열 : " + data1 +", 숫자: " + data2;
    }
    //http://localhost:8000/study/text/2?data1=aaa&data2=100
    @ResponseBody
    @GetMapping("/study/text/3")
    public String 요청데이터Obj(RequestStudyDto requestStudyDto){
        return requestStudyDto.toString();
    }
    //http://localhost:8000/study/text/3?name=peng&email=qwer@gmail.com&address=pus

    @PostMapping("/study/student/1")
    public String getJsonAjax(@RequestBody RequestStudyDto requestStudyDto){
        return requestStudyDto.toString();
    }

    @ResponseBody
    @GetMapping("/study/student/2")
    public ResponseEntity<?> getJsonAjax2(){
        RequestStudyDto requestStudyDto = new RequestStudyDto();
        requestStudyDto.setName("aaa");
        requestStudyDto.setEmail("qwer@gmail.com");
        requestStudyDto.setAddress("부산 남포동");

        return new ResponseEntity<>(requestStudyDto, HttpStatus.OK);
    }

}
