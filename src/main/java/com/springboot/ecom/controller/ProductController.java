package com.springboot.ecom.controller;

import com.springboot.ecom.dto.Product.ProductDto;
import com.springboot.ecom.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;
    @PostMapping("/add/{sellerId}/{categoryId}")
    public void add(@PathVariable  long sellerId,
                    @PathVariable  long categoryId,
                 @Valid @RequestBody ProductDto productDto){

        productService.add(sellerId,categoryId,productDto);
    }

}
