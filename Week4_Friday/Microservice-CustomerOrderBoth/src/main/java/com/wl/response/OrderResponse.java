package com.wl.response;

import com.wl.entity.Order;

public class OrderResponse {
    private Long orderId;
    private CustomerResponse customerResponse;
    private String orderDate;
    private String shipToAddress;

    public OrderResponse(Order order) {
        this.orderId = order.getOrderId();
        this.orderDate = order.getOrderDate();
        this.shipToAddress = order.getShipToAddress();
    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public CustomerResponse getCustomerResponse() {
        return customerResponse;
    }

    public void setCustomerResponse(CustomerResponse customerResponse) {
        this.customerResponse = customerResponse;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShipToAddress() {
        return shipToAddress;
    }

    public void setShipToAddress(String shipToAddress) {
        this.shipToAddress = shipToAddress;
    }
}
