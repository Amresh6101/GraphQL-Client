package com.graphqlclient.service;

import com.graphqlclient.client.OrderEcommClient;
import com.graphqlclient.dto.OrderRequestDTO;
import com.graphqlclient.dto.OrderResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderClientService {

    @Autowired
    private OrderEcommClient orderEcommClient;

    // createOrder
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO){
        return orderEcommClient.addOrder(orderRequestDTO);
    }

    //getOrders
    public List<OrderResponseDTO> getAllOrders(){
        return orderEcommClient.getOrders();
    }

    //getOrderById
    public OrderResponseDTO  getOrderById(Integer id){
        return orderEcommClient.getOrderById(id);
    }

    //deleteOrder
    public Boolean deleteOrderById(Integer id){
        return orderEcommClient.deleteOrderById(id);
    }
}
