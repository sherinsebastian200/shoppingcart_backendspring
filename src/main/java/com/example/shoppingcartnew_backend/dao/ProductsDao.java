package com.example.shoppingcartnew_backend.dao;

import com.example.shoppingcartnew_backend.model.Products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductsDao extends CrudRepository<Products,Integer> {
    @Query(value = "SELECT `id`, `category`, `description`, `image`, `price`, `productname` FROM `products` WHERE `productname` LIKE %:productname%",nativeQuery = true)

    List<Products> SearchProducts(@Param("productname")String productname);
}
