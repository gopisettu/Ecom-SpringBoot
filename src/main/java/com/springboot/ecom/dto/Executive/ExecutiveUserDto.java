package com.springboot.ecom.dto.Executive;

import com.springboot.ecom.enums.JobTitle;

public record ExecutiveUserDto(
        String name,
        JobTitle jobTitle,
        String username,
        String password

) {

}
