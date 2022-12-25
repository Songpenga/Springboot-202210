package com.study.springboot202210.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ProductDto {
    private String productCode;
    private String productName;
    private String price;
    private String stock;
//Dto 는  getter setter 가 있어야 한다.

}
