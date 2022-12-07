package com.example.shoppingcartnew_backend.dao;

import com.example.shoppingcartnew_backend.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<User,Integer> {

    @Query(value = "SELECT `id`, `address`, `confirmpassword`, `email`, `mobno`, `name`, `password` FROM `user` WHERE `name` LIKE %:name%",nativeQuery = true)

    List<User> SearchUser(@Param("name")String name);
}
