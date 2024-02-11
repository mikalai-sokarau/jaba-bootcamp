package dev.sokarau.kafkaonlineorders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaOnlineOrdersApplication {
	public static void main(String[] args) {
		SpringApplication.run(KafkaOnlineOrdersApplication.class, args);
	}
}
