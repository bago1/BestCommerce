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

//    @Query("SELECT u FROM Products LEFT JOIN u.id s u WHERE user.username = ?1")
//    List<Products> findAllByUsername(String username);
}

//    SELECT f from Student f LEFT JOIN f.classTbls s WHERE s.ClassName = 'abc'
//SELECT b.book_name, a.author_name, c.cat_name
//        FROM Books b
//        JOIN BookAuthor ba ON b.book_id =ba.book_id
//        JOIN Authors a ON a.author_id = ba.author_id
//        JOIN BookCategory bc ON bc.book_id =b.book_id
//        JOIN Categories c ON bc.cat_id = c.cat_name
//        WHERE b.book_id = 101 -- specify book id