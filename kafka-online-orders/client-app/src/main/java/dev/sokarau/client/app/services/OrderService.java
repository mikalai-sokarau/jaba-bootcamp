package dev.sokarau.client.app.services;

import com.google.gson.Gson;
import dev.sokarau.client.app.dto.OrderDTO;
import dev.sokarau.client.app.dto.OrderRepository;
import dev.sokarau.client.app.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private static final String ORDERS_TOPIC_NAME = "orders";

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private Gson gson;

    public OrderService(OrderRepository orderRepository) {
        // clean up a database from previous orders when the service starts
        orderRepository.deleteAll();
    }

    public List<Order> allOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> singleOrder(String correlationId) {
        return orderRepository.findOrderByCorrelationId(correlationId);
    }

    public String createOrder(String name) {
        Order order = new Order(name);
        OrderDTO orderDTO = OrderDTO.builder()
                .correlationId(order.getCorrelationId())
                .name(order.getName())
                .status(order.getStatus())
                .build();

        orderRepository.save(order);
        kafkaTemplate.send(ORDERS_TOPIC_NAME, gson.toJson(orderDTO));
        System.out.println("Client sent a message: " + orderDTO);

        return order.getCorrelationId();
    }

    public Order updateOrderStatus(String correlationId, String status) {
        Optional<Order> optionalOrder = orderRepository.findOrderByCorrelationId(correlationId);

        if(optionalOrder.isEmpty()) {
            return null;
        }

        Order order = optionalOrder.get();

        order.setStatus(status);
        order.updateTimestamp();

        orderRepository.save(order);

        return order;
    }
}
