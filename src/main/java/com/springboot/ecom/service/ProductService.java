package com.springboot.ecom.service;

import com.springboot.ecom.dto.Product.ProductDto;
import com.springboot.ecom.exception.ResourseNotFoundException;
import com.springboot.ecom.mapper.ProductMapper;
import com.springboot.ecom.model.Category;
import com.springboot.ecom.model.Product;
import com.springboot.ecom.model.Seller;
import com.springboot.ecom.repository.CategoryRepository;
import com.springboot.ecom.repository.ProductRepository;
import com.springboot.ecom.repository.SellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private  final SellerRepository sellerRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public void add(long sellerId, long categoryId, ProductDto productDto) {
        Seller seller=sellerRepository.findById(sellerId)
                .orElseThrow(()->new ResourseNotFoundException("Seller Id Not found"));
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourseNotFoundException("Category Id not found"));
        Product product= ProductMapper.mapProductDtoToEntity(productDto);
        product.setSeller(seller);
        product.setCategory(category);
        productRepository.save(product);
    }
}
