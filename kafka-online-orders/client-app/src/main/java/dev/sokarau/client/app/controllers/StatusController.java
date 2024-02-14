package dev.sokarau.client.app.controllers;

import dev.sokarau.client.app.model.Order;
import dev.sokarau.client.app.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("pizzeria/api/v1/statuses")
public class StatusController {
    @Autowired
    private OrderService orderService;

    // Get status by correlationId
    @GetMapping("/{correlationId}")
    public ResponseEntity<Optional<String>> getStatusByCorrelationId(@PathVariable String correlationId) {
        Optional<Order> optionalOrder = orderService.singleOrder(correlationId);

        if(optionalOrder.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        String status = optionalOrder.get().getStatus();

        return new ResponseEntity<>(Optional.ofNullable(status), HttpStatus.OK);
    }

    // Update status by correlationId (for testing purposes)
    @PutMapping("/{correlationId}")
    public ResponseEntity<Order> updateStatusByCorrelationId(@PathVariable String correlationId,
            @RequestBody Map<String, String> payload) {
        Order order = orderService.updateOrderStatus(correlationId, payload.get("status"));

        if(order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
