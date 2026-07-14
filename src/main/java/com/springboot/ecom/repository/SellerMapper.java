package com.springboot.ecom.repository;

import com.springboot.ecom.dto.Seller.SellerDto;
import com.springboot.ecom.model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SellerMapper {
    public static Seller mapSellerDtoToEntity(SellerDto sellerDto){

        Seller seller =new Seller();
        seller.setName(sellerDto.name());
        seller.setContact(sellerDto.contact());
        seller.setCity(sellerDto.city());
        return  seller;
    }
}
