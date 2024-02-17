package dev.sokarau.courier.app;

import dev.sokarau.common.KafkaConsumerConfig;
import dev.sokarau.common.KafkaProducerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({KafkaConsumerConfig.class, KafkaProducerConfig.class})
public class CourierApp {
	public static void main(String[] args) { SpringApplication.run(CourierApp.class, args); }
}
