package com.springboot.ecom.service;

import com.springboot.ecom.dto.Seller.SellerDto;
import com.springboot.ecom.enums.Role;
import com.springboot.ecom.exception.ResourseNotFoundException;
import com.springboot.ecom.mapper.ExecutiveMapper;
import com.springboot.ecom.mapper.UserMapper;
import com.springboot.ecom.model.Executive;
import com.springboot.ecom.model.Seller;
import com.springboot.ecom.model.User;
import com.springboot.ecom.repository.ExecutiveRepository;
import com.springboot.ecom.repository.SellerMapper;
import com.springboot.ecom.repository.SellerRepository;
import com.springboot.ecom.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SellerService {
    private final ExecutiveRepository executiveRepository;
    private final SellerRepository sellerRepository;
    private final UserRepository userRepository;

    public void addSellerByExecutive(long executiveId, SellerDto sellerDto) {
        Seller seller = SellerMapper.mapSellerDtoToEntity(sellerDto);

        User user = UserMapper.mapUserDtoToEntity(sellerDto.username(), sellerDto.password(), Role.SELLER);
        user = userRepository.save(user);
        Executive executive = executiveRepository.findById(executiveId)
                .orElseThrow(() -> new ResourseNotFoundException("Executive Id not found"));
        seller.setUser(user);
        seller.setExcecutive(executive);
        sellerRepository.save(seller);

    }
}
