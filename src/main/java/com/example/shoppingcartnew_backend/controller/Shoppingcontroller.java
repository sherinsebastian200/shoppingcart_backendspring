package com.example.shoppingcartnew_backend.controller;
import com.example.shoppingcartnew_backend.dao.ProductsDao;
import com.example.shoppingcartnew_backend.dao.UserDao;
import com.example.shoppingcartnew_backend.model.Products;
import com.example.shoppingcartnew_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController

public class Shoppingcontroller {

    @Autowired
    private ProductsDao dao;

    @Autowired
    private UserDao d;

    @CrossOrigin("*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")

    public Map<String,String>AddProducs(@RequestBody Products p)
    {
        System.out.println(p.getProductname().toString());
        System.out.println(p.getImage().toString());
        System.out.println(p.getCategory().toString());
        System.out.println(p.getDescription().toString());
        System.out.println(p.getPrice());
        dao.save(p);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Products> ViewProducts()
    {
        return (List<Products>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Products> SearchProducts(@RequestBody Products p)
    {
        String productname=p.getProductname().toString();
        System.out.println(productname);
        return (List<Products>) dao.SearchProducts(p.getProductname());
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userregistration",consumes = "application/json",produces = "application/json")
    public Map<String,String> User(@RequestBody User u)
    {
        System.out.println(u.getName().toString());
        System.out.println(u.getAddress().toString());
        System.out.println(u.getMobno());
        System.out.println(u.getEmail().toString());
        System.out.println(u.getPassword().toString());
        System.out.println(u.getConfirmpassword().toString());
        d.save(u);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;

    }
}