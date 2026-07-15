package com.springboot.ecom.repository;

import com.springboot.ecom.dto.response.Product.OrderDto;
import com.springboot.ecom.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

@Query("""
        SELECT c
        FROM Customer c
        WHERE c.is_active = true
        """)
Page<Customer> fetchAll(Pageable pageable);


    @Query("""
       SELECT c
       FROM Customer c
       WHERE c.id = ?1
       AND c.is_active = true
       """)
    Optional<Customer> fetchById(long id);

    @Query("""
Select p.id as productId,
p.title as productTitle,
p.price as actualPrice,
cp.discount as discount,
cp.quantity as  quantity,
cp.purchaseDate as dateOfPurchase,
s.name as sellerName,
p.price -(p.price *(cp.discount / 100)) as paidPrice,
false as isReviewGiven,
r.rating as rating,
r.reviewText as reviewText,
false as isReturnAllowed,
cp.deliveredDate as deliveredDate
from CustomerProduct cp
JOIN cp.customer c
JOIN cp.product p
JOIN p.seller s
JOIN s.user u
JOIN Review r on r.product.id=p.id
where c.user.username=?1
order by cp.purchaseDate DESC
""")
    List<OrderDto> getProductsPurchasedByCustomer(String customerUsername,Pageable pageable);
}
