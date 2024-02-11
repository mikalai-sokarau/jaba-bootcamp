package dev.sokarau.client.app.dto;

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
    private String orderId;
    private String correlationId;
    private String name;
    private String status;
    private String timestamp;
    public Order(String name) {
        this.id = ObjectId.get();
        this.correlationId = ObjectId.get().toHexString();
        this.name = name;
        this.orderId = ObjectId.get().toHexString();
        this.status = "CREATED";
        this.timestamp = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
        );
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getOrderId() {
        return orderId;
    }
    public String getCorrelationId() {
        return correlationId;
    }
}
