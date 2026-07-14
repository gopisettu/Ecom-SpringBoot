package com.springboot.ecom.mapper;

import com.springboot.ecom.dto.Product.ProductDto;
import com.springboot.ecom.model.Product;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public  static Product mapProductDtoToEntity(ProductDto productDto){
        Product product=new Product();
        product.setTitle(productDto.title());
        product.setDescription(productDto.description());
        product.setPrice(productDto.price());
        return product;
    }
}
