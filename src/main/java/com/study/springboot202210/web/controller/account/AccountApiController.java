package com.study.springboot202210.web.controller.account;

import com.study.springboot202210.aop.annotation.ParamsAspect;
import com.study.springboot202210.aop.annotation.PrintTestAspect;
import com.study.springboot202210.aop.annotation.TimerAspect;
import com.study.springboot202210.aop.annotation.ValidAspect;
import com.study.springboot202210.service.UserService;
import com.study.springboot202210.web.dto.CMRespDto;
import com.study.springboot202210.web.dto.UserDto;
import com.study.springboot202210.web.dto.UserNameDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    // Simple Log Fasade
//    private static final Logger LOG = LoggerFactory.getLogger(AccountApiController.class);

    @Autowired
    private UserService userService;

    @ParamsAspect
    @TimerAspect
    @ValidAspect
    @GetMapping("/username")
    public ResponseEntity<?> duplicateUsername(@Valid UserNameDto usernameDto, BindingResult bindingResult) {
        userService.duplicateUsername(usernameDto.getUsername());

        return ResponseEntity.ok().body(new CMRespDto<>("가입 가능한 사용자이름", true));
    }

    @ParamsAspect
    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입 완료", null));
    }
}
            //NotBlank - bindingResult
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        userService.duplicateUsername(userNameDto.getUsername());
//        stopWatch.stop();

//        System.out.println(stopWatch.getTotalTimeSeconds());
//_________________________________________________________________________
//        System.out.println(userDto);
//        System.out.println(bindingResult.getFieldError());
//        if (bindingResult.hasErrors()){
//            Map<String,String> errorMap = new HashMap<>();
//            bindingResult.getFieldErrors().forEach(error -> {
//                errorMap.put(error.getField(), error.getDefaultMessage());
//            });
//
//            errorMap.forEach((k, v) -> {
//                System.out.println(k + ": " + v);
//            });
//        }
