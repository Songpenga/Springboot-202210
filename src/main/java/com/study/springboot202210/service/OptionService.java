package com.study.springboot202210.service;

import com.study.springboot202210.repository.OptionRepository;
import com.study.springboot202210.web.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

    @Autowired
    private OptionRepository optionRepository;

    public int addCategory(CategoryDto categoryDto) {

        System.out.println("데이터베이스에 insert 하기전 : "+ categoryDto);

        return optionRepository.saveCategory(categoryDto) > 0 ? categoryDto.getCategoryId() : 0;
        //saveCategory : OptionRepository
    }

    public List<CategoryDto> getCategories() {
        return optionRepository.getCategories();
    }

    public void modifyCategory(int categoryId, CategoryDto categoryDto){
        categoryDto.setCategoryId(categoryId);
        optionRepository.modifyCategory(categoryDto);
    }
}
