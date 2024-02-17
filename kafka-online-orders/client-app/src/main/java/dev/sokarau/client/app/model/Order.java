package dev.sokarau.client.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Document(collection = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private ObjectId id;
    private String correlationId;
    private String name;
    private String status;
    private String timestamp;
    public Order(String name) {
        this.id = ObjectId.get();
        this.name = name;
        this.correlationId = ObjectId.get().toHexString();
        this.status = "CREATED";

        updateTimestamp();
    }
    public void updateTimestamp() {
        this.timestamp = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
        );
    }
}
