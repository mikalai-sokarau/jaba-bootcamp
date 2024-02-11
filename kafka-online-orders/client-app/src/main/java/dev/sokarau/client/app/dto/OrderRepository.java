package dev.sokarau.client.app.dto;

import dev.sokarau.client.app.dto.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends MongoRepository<Order, ObjectId> {
    Optional<Order> findOrderByOrderId(String orderId);
}
