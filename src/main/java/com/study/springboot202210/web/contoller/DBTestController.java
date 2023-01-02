package com.study.springboot202210.web.contoller;

import com.study.springboot202210.service.UserService;
import com.study.springboot202210.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/db/test")
public class DBTestController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {

        System.out.println(userDto);
        int userId = userService.addUser(userDto);
        //return new ResponseEntity<>("응답할 데이터", HttpStatus.CREATED);

        return ResponseEntity.created(URI.create("/api/db/test/user/" + userId)).body(userDto); // integer
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable int userId){
        UserDto userDto = userService.getUser(userId);
        return ResponseEntity.ok().body(userDto);
    }
}
