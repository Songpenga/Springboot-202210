package com.study.springboot202210.web.contoller;

import com.study.springboot202210.service.OptionService;
import com.study.springboot202210.service.UserService;
import com.study.springboot202210.web.dto.CategoryDto;
import com.study.springboot202210.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/option")
public class OptionController {

    @Autowired
    private OptionService optionService;

    @PostMapping("/category") //요청 매핑 주소
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto) {
        System.out.println(categoryDto);
        return ResponseEntity
                .created(URI.create("/api/option/category" + optionService.addCategory(categoryDto)))
                .body(categoryDto);
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories(){

        return ResponseEntity.ok(optionService.getCategories());//getCategories 값 자체가 list
    }

    @PutMapping("/category/{categoryId}")
    public ResponseEntity<?> modifyCategory(@PathVariable int categoryID, @RequestBody CategoryDto categoryDto){
        optionService.modifyCategory(categoryID, categoryDto);
        return ResponseEntity.ok(true);
    }
}
