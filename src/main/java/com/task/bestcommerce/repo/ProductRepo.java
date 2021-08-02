package com.task.bestcommerce.repo;

import com.task.bestcommerce.models.Merchant;
import com.task.bestcommerce.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Products,Integer> {
    Products findProductsByproductName(String name);

    @Query(value =
            "select * from products p left join user u on p. merchant_id = u.merchant_id where u.username = ?1"
            ,nativeQuery = true)
    List<Products> findAllByUsername(String username);
}
    