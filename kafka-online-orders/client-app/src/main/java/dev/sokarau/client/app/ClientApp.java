package dev.sokarau.client.app;

import dev.sokarau.common.KafkaConsumerConfig;
import dev.sokarau.common.KafkaProducerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Import({KafkaConsumerConfig.class, KafkaProducerConfig.class})
public class ClientApp {
	public static void main(String[] args) { SpringApplication.run(ClientApp.class, args); }
}
