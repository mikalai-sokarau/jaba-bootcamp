package dev.sokarau.client.app.repository;

import dev.sokarau.client.app.model.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends MongoRepository<Order, ObjectId> {
    Optional<Order> findOrderByCorrelationId(String correlationId);
}
