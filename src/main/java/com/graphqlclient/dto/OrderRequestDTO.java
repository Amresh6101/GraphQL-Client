package com.graphqlclient.dto;

public class OrderRequestDTO {

    private String orderDate;
    private Double orderPrice;
    private String orderDescription;
    private Integer id;

    public OrderRequestDTO() {
    }

    public OrderRequestDTO(String orderDate, Double orderPrice, String orderDescription, Integer id) {
        this.orderDate = orderDate;
        this.orderPrice = orderPrice;
        this.orderDescription = orderDescription;
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
