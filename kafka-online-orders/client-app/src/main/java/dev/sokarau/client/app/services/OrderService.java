package dev.sokarau.client.app.services;

import dev.sokarau.client.app.dto.Order;
import dev.sokarau.client.app.dto.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> allOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> singleOrder(String orderId) {
        return orderRepository.findOrderByOrderId(orderId);
    }

    public String createOrder(String name) {
        Order order = new Order(name);

        orderRepository.save(order);

        return order.getOrderId();
    }

    public Order updateOrderStatus(String orderId, String status) {
        Optional<Order> optionalOrder = orderRepository.findOrderByOrderId(orderId);

        if(optionalOrder.isEmpty()) {
            return null;
        }

        Order order = optionalOrder.get();
        order.setStatus(status);

        orderRepository.save(order);

        return order;
    }
}
