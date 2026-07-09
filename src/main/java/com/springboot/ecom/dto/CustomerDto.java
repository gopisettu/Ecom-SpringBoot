package com.springboot.ecom.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;


public record CustomerDto(
        @NotBlank
        String name,
        @NotBlank
        String city
) {
}
