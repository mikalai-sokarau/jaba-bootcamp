## Description

This is a system for creating online orders for pizzeria.
It consists of 3 applications:

- `client-app` - service for creating orders
- `pizzeria-app` - service for processing orders
- `courier-app` - service for delivering orders

### Client app
`client-app` is a service for receiving and storing incoming orders from clients. It has REST API with two endpoints:

- `POST /order` - for creating a new order
- `GET /statuses/{id}` - for getting information about the status of the order by its id

The service uses Kafka to send orders to the `orders` topic and to receive notifications about the status of the order from the `notifications` topic.

It also uses MongoDB to store information about the orders.

### Pizzeria app
`pizzeria-app` is a service for processing orders. It's a Kafka consumer that listens to the `orders` topic and processes incoming orders. It also sends notifications about the status of the order to the `notifications` topic.

### Courier app
`courier-app` is a service for delivering orders. It's a Kafka consumer that listens to the `notifications` topic and processes incoming orders. It also sends notifications about the status of the order to the `notifications` topic.

## Communication between services
The whole flow of communication between the services is shown in the diagram below:
![services-communication-process](https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/aea12072-caf9-4f81-b7cf-6746f0c49723)

## Tools

- Java 17
- Spring Boot
- Kafka
- MongoDB
- Maven

## Instructions

MongoDB and Kafka are running externally and not required to be installed locally.

Set up .env variables based on the .env.example file in each service.

From the root directory:

- `> mvn clean install package`
- `> java -jar client-app/target/client-app-0.0.1.jar`
- `> java -jar courier-app/target/courier-app-0.0.1.jar`
- `> java -jar pizzeria-app/target/pizzeria-app-0.0.1.jar`

Create an order by sending a POST request to `http://localhost:8080/api/v1/orders` with the following body:

```json
{
  "name": "<order name>"
}
```

Use the `id` from the response to get the status of the order by sending a GET request to `http://localhost:8080/api/v1/statuses/<id>`.

\* Postman collection is also available in the root directory.

## Recording
![online-order](https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/6bac54bf-9839-44ea-93ca-70bb7121302c)
