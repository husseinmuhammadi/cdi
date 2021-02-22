package com.javastudio.cdi.service;

import com.javastudio.cdi.api.OrderService;
import com.javastudio.cdi.dto.Order;

import javax.enterprise.event.Event;

public class OrderServiceImpl implements OrderService {
    Event<Order> orderEvent;

    @Override
    public void add(Order order) {
        // validate
        // save order in database

        orderEvent.fire(order);
    }
}
