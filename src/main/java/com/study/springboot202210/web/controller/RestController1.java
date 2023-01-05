package com.study.springboot202210.web.controller;

import com.study.springboot202210.web.dto.CMRespDto;
import com.study.springboot202210.web.dto.UserDto;
import com.study.springboot202210.web.exception.CustomTestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestController1 {

    @GetMapping("/api/test/user-dto/str")
    public String getUserDtoStr(){
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        return userDto.toString();
    }

    @GetMapping("/api/test/user-dto/obj")
    public ResponseEntity<?> getUserDtoObj(){
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.add("HeaderTest", "abc");
      //  return new ResponseEntity<>(headers, HttpStatus.OK);
        return ResponseEntity.ok().headers(headers).body(userDto);
        //return new ResponseEntity(userDto, null, 400);
        //return new ResponseEntity<UserDto>(userDto, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/api/test/user-dto/cm")
    public ResponseEntity<?> getUserDto(){
        UserDto userDto = UserDto.builder()
                .username("test")
                .password("1234")
                .build();
        //CMRespDto<UserDto> cm = CMRespDto.builder().message("test유저 정보 응답").data(userDto);
        return ResponseEntity.ok().body(new CMRespDto<>("test유저 정보 응답", userDto));
    }

    @PostMapping("/api/test/user")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto){

        if( userDto.getUsername().isBlank()) { // 유저이름 비어있다면
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("username", "아이디를 입력하세요");

            throw new CustomTestException("유효성 검사 실패", errorMap);
        }

        userDto.setUserId(200);
        return ResponseEntity.created(null)
                .body(new CMRespDto<>(userDto.getUserId()+"사용자 추가 성공!!", userDto));
    }
}
