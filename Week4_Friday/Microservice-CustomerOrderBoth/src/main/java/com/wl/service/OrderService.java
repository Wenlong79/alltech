package com.wl.service;

import com.wl.entity.Order;
import com.wl.repository.OrderRepository;
import com.wl.request.CreateOrderRequest;
import com.wl.response.CustomerResponse;
import com.wl.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    WebClient webClient;

    public OrderResponse createOrder(CreateOrderRequest createOrderRequest) {

        Order order = new Order();
        order.setCustomerId(createOrderRequest.getCustomerId());
        order.setOrderDate(createOrderRequest.getOrderDate());
        order.setShipToAddress(createOrderRequest.getShipToAddress());
        order = orderRepository.save(order);

        OrderResponse orderResponse = new OrderResponse(order);
        orderResponse.setCustomerResponse(getCustomerById(order.getCustomerId()));

        return orderResponse;
    }

    public OrderResponse getById(long id) {
        Order order = orderRepository.findById(id).get();
        OrderResponse orderResponse = new OrderResponse(order);
        orderResponse.setCustomerResponse(getCustomerById(order.getCustomerId()));
        return orderResponse;
    }

    public CustomerResponse getCustomerById(long customerId) {
        Mono<CustomerResponse> customerResponseMono =
                webClient.get().uri("/getById/" + customerId)
                        .retrieve().bodyToMono(CustomerResponse.class);

        return customerResponseMono.block();
    }

}
