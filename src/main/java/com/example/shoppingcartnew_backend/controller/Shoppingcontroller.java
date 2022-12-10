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
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")

    public Map<String, String> AddProducts(@RequestBody Products p) {
        System.out.println(p.getProductname().toString());
        System.out.println(p.getImage().toString());
        System.out.println(p.getCategory().toString());
        System.out.println(p.getDescription().toString());
        System.out.println(p.getPrice());
        dao.save(p);
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Products> ViewProducts() {
        return (List<Products>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search", consumes = "application/json", produces = "application/json")
    public List<Products> SearchProducts(@RequestBody Products p) {
        String productname = p.getProductname().toString();
        System.out.println(productname);
        return (List<Products>) dao.SearchProducts(p.getProductname());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userregistration", consumes = "application/json", produces = "application/json")
    public Map<String, String> User(@RequestBody User u) {
        System.out.println(u.getName().toString());
        System.out.println(u.getAddress().toString());
        System.out.println(u.getMobno());
        System.out.println(u.getEmail().toString());
        System.out.println(u.getPassword().toString());
        System.out.println(u.getConfirmpassword().toString());
        d.save(u);
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userlogin", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserLogin(@RequestBody User u) {

        String email = u.getEmail().toString();
        String password = u.getPassword().toString();
        System.out.println(email);
        System.out.println(password);
        List<User> result = (List<User>) d.UserLogin(u.getEmail(), u.getPassword());
        HashMap<String, String> map = new HashMap<>();
        if (result.size() == 0) {
            map.put("status", "failed");
            map.put("message","user not exist");

        } else {
            int id = result.get(0).getId();
            map.put("userId", String.valueOf(id));
            map.put("status", "success");
            map.put("message", "success");
        }
        return map;


    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewprofile",consumes =  "application/json", produces = "application/json")
    public List<User>ViewProfile(@RequestBody User u) {
        String id=String.valueOf(u.getId());
        System.out.println(id);
        return (List<User>) d.ViewProfile(u.getId());
    }

}