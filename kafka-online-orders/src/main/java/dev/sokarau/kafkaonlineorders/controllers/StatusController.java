package dev.sokarau.kafkaonlineorders.controllers;

import dev.sokarau.kafkaonlineorders.Order;
import dev.sokarau.kafkaonlineorders.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/statuses")
public class StatusController {
    @Autowired
    private OrderService orderService;

    // Get status by orderId
    @GetMapping("/{orderId}")
    public ResponseEntity<Optional<String>> getStatusByOrderId(@PathVariable String orderId) {
        Optional<Order> optionalOrder = orderService.singleOrder(orderId);

        if(optionalOrder.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        String status = optionalOrder.get().getStatus();

        return new ResponseEntity<>(Optional.ofNullable(status), HttpStatus.OK);
    }

    // Update status by orderId (for testing purposes)
    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateStatusByOrderId(@PathVariable String orderId, @RequestBody Map<String, String> payload) {
        Order order = orderService.updateOrderStatus(orderId, payload.get("status"));

        if(order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
