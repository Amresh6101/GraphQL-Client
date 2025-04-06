package com.graphqlclient.controller;

import com.graphqlclient.dto.OrderRequestDTO;
import com.graphqlclient.dto.OrderResponseDTO;
import com.graphqlclient.service.OrderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderClientService orderClientService;

    //addOrder
    @PostMapping("/addorder")
    public OrderResponseDTO addOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        return orderClientService.createOrder(orderRequestDTO);
    }

    @GetMapping("/orders")
    public List<OrderResponseDTO> getAllOrders(){
        return orderClientService.getAllOrders();
    }

    @GetMapping("/order/{id}")
    public OrderResponseDTO getOrderById(@PathVariable Integer id){
        return orderClientService.getOrderById(id);
    }

    @DeleteMapping("/deleteorder/{id}")
    public boolean deleteOrderById(@PathVariable Integer id){
        return orderClientService.deleteOrderById(id);
    }
}
