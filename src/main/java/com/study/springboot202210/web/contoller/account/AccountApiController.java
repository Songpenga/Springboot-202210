package com.study.springboot202210.web.contoller.account;

import com.study.springboot202210.service.UserService;
import com.study.springboot202210.web.dto.CMRespDto;
import com.study.springboot202210.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/username")
    public  ResponseEntity<?> duplicateUsername(String username) {
        userService.duplicateUsername(username);
        return ResponseEntity.ok().body(new CMRespDto<>("가입가능한 사용자이름", true));
    }
    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody UserDto userDto){
        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입완료", null));

    }
}
