package com.springboot.ecom.dto.response.Product;

import java.time.Instant;

public record OrderDto(
        Long productId,
        String productTitle,
        double actualPrice,
        double discount,
        int quantity,
        Instant dateOfPurchase,
        String sellerName,
        double paidPrice,
        boolean isReviewGiven,
        int rating,
        String reviewText,
        boolean isReturnAllowed,
        Instant deliveredDate
) {
}
