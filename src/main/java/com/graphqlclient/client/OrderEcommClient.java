package com.graphqlclient.client;

import com.graphqlclient.dto.OrderRequestDTO;
import com.graphqlclient.dto.OrderResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderEcommClient {

    @Autowired
    private HttpGraphQlClient graphQlClient;

    //addOrder
    public OrderResponseDTO addOrder(OrderRequestDTO orderRequestDTO) {
        String mutation = """
        mutation createOrder($orderDate: String, $orderPrice: Float, $orderDescription: String,$id: ID!) {
          createOrder(
            orderDate: $orderDate,
            orderPrice: $orderPrice,
            orderDescription: $orderDescription
            id: $id
          ) {
             orderId
             orderPrice
             orderDate
             orderDescription             
          }
        }
    """;

        return graphQlClient.document(mutation)
                .variable("orderDate",orderRequestDTO.getOrderDate())
                .variable("orderPrice",orderRequestDTO.getOrderPrice())
                .variable("orderDescription",orderRequestDTO.getOrderDescription())
                .variable("id",orderRequestDTO.getId())
                .retrieve("createOrder")
                .toEntity(OrderResponseDTO.class)
                .block();
    }

    //getOrders
    public List<OrderResponseDTO> getOrders(){
        String query= """
                query {
                  getAllOrders{
                    orderId
                    orderDate
                    orderPrice
                    orderDescription
                   
                  }
                }
                """;
        return graphQlClient.document(query)
                .retrieve("getAllOrders")
                .toEntityList(OrderResponseDTO.class)
                .block();
    }

    //getOrderById
    public OrderResponseDTO getOrderById(Integer id){
        String query= """
                query($id: ID!) {
                  getOrderById(orderId: $id){
                    orderId
                    orderDate
                    orderPrice
                    orderDescription
               
                  }
                }
                """;
        return graphQlClient.document(query)
                .variable("id",id)
                .retrieve("getOrderById")
                .toEntity(OrderResponseDTO.class)
                .block();
    }

    //deleteOrder
    public Boolean deleteOrderById(Integer id) {
        String mutation = """
            mutation DeleteOrder($id: ID!) {
              deleteOrder(orderId: $id)
            }
            """;

        return graphQlClient.document(mutation)
                .variable("id", id)
                .retrieve("deleteOrder")
                .toEntity(Boolean.class)
                .block();
    }
}
