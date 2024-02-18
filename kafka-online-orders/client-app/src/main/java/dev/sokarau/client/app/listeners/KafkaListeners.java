package dev.sokarau.client.app.listeners;

import com.google.gson.Gson;
import dev.sokarau.client.app.services.OrderService;
import dev.sokarau.common.OrderDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    private static final String NOTIFICATIONS_TOPIC_NAME = "notifications";
    private static final Logger logger = LogManager.getLogger(OrderService.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    Gson gson;

    @KafkaListener(topicPartitions = { @TopicPartition(topic = NOTIFICATIONS_TOPIC_NAME, partitions = { "0" } )})
    void notificationsTopicListener(String message) {
        OrderDTO orderDTO = gson.fromJson(message, OrderDTO.class);

        orderService.updateOrderStatus(orderDTO.getCorrelationId(), orderDTO.getStatus());

        logger.info("Client received a message: " + orderDTO);
    }
}
