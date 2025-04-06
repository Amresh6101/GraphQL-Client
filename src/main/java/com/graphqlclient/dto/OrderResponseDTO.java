package com.graphqlclient.dto;


public class OrderResponseDTO {
    private Integer orderId;
    private Double orderPrice;
    private String orderDescription;
    private String orderDate;

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public OrderResponseDTO() {
    }

    public OrderResponseDTO(Integer orderId, Double orderPrice, String orderDescription, String orderDate) {
        this.orderId = orderId;
        this.orderPrice = orderPrice;
        this.orderDescription = orderDescription;
        this.orderDate = orderDate;

    }


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }
}
