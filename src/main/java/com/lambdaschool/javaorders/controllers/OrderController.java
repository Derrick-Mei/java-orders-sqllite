package com.lambdaschool.javaorders.controllers;

import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {"/order"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController
{

    @Autowired
    OrderRepository orderrepos;

    @GetMapping("")
    public List<Order> allOrders()
    {
        return orderrepos.findAll();
    }

}
