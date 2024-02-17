package dev.sokarau.courier.app.listeners;

import com.google.gson.Gson;
import dev.sokarau.common.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Component
public class KafkaListeners {
    private static final String NOTIFICATIONS_TOPIC_NAME = "notifications";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    Gson gson;

    @KafkaListener(topicPartitions = { @TopicPartition(topic = NOTIFICATIONS_TOPIC_NAME, partitions = { "1" } )})
    void listener(String message) {
        OrderDTO orderDTO = gson.fromJson(message, OrderDTO.class);

        sendMessageWithDelay(orderDTO, "IN_DELIVERY", 3000);
        sendMessageWithDelay(orderDTO, "DELIVERED", 6000);
    }

    private void sendMessageWithDelay(OrderDTO orderDTO, String status, int delay){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                orderDTO.setStatus(status);
                kafkaTemplate.send(NOTIFICATIONS_TOPIC_NAME, 0, "", gson.toJson(orderDTO));
            }
        }, delay);
    }
}
