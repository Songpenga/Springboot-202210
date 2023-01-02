package com.study.springboot202210.web.contoller;

import com.study.springboot202210.web.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductTestController {

    @GetMapping("/product/addition")
    public String loadAddtion() {
        return "product/product_add";
    }

//    @PostMapping("/api/product")
//    public String registerProduct(HttpServletRequest request) {
//        System.out.println(request.getParameter("price"));
//        return "product/product_view";
//    }

//    @PostMapping("/api/product")
//    public String registerProduct(@RequestParam String productCode,
//                                  @RequestParam String productName,
//                                  @RequestParam("price") int price,
//                                  @RequestParam int stock) {
//        System.out.println(productCode);
//        System.out.println(price);
//        return "product/product_view";
//        //변수명, 파리미터값 주의
//    }

    @PostMapping("/api/product")
    public String registerProduct(Model model, ProductDto productDto) {
        model.addAttribute("productDto", productDto);
        System.out.println(productDto);
        return "product/product_view";
        //변수명, 파리미터값 주의

    }

    @GetMapping("/product/addition2")
    public String loadAddition2() {
        return "product/product_add2";
    }

    @ResponseBody
    @PostMapping("/api/product/2")
    public String registerProduct(@RequestBody ProductDto productDto){ //JSON필수 RequestBody
        System.out.println(productDto);
        return "텍스트 데이터 응답";
    }
}
