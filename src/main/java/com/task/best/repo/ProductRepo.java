package com.task.best.repo;

import com.task.best.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Products,Integer> {
    List<Products> findProductsByInventoryGreaterThan(Integer num);
}
