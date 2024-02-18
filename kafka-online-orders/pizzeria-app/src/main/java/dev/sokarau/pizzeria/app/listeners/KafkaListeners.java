package dev.sokarau.pizzeria.app.listeners;

import com.google.gson.Gson;
import dev.sokarau.common.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
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

    @KafkaListener(topics = "orders", groupId = "groupId")
    void listener(String message) {
        OrderDTO orderDTO = gson.fromJson(message, OrderDTO.class);

        sendMessageWithDelay(orderDTO, "COOKING", 0, 3000);
        sendMessageWithDelay(orderDTO, "READY_TO_PICK_UP", 0, 6000);
        sendMessageWithDelay(orderDTO, "READY_TO_PICK_UP", 1, 6000);
    }

    private void sendMessageWithDelay(OrderDTO orderDTO, String status, int partition, int delay){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                orderDTO.setStatus(status);
                kafkaTemplate.send(NOTIFICATIONS_TOPIC_NAME, partition, "", gson.toJson(orderDTO));
            }
        }, delay);
    }
}
