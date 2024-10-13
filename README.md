# Kafka Spring Boot Demo

This project demonstrates how to use Apache Kafka with Spring Boot and Spring Cloud Stream. It uses the Supplier, Consumer, and Function interfaces from Java 8 to interact with Kafka topics.

## Key Components

- `PageEvent`: A simple data class representing an event on a page.
- `EventPageController`: A REST controller that generates a `PageEvent` and sends it to a Kafka topic.
- `PageEventService`: Defines a `Supplier`, `Consumer`, and `Function` for `PageEvent`.

## How It Works

1. The `Supplier` generates a `PageEvent` and sends it to a Kafka topic.
2. The `Function` consumes a `PageEvent` from a Kafka topic, transforms it, and sends it to another Kafka topic.
3. The `Consumer` consumes the transformed `PageEvent` from a Kafka topic.

## Running the Application

1. Start your Kafka and Zookeeper servers. You can use the provided `docker-compose.yml` file to start these servers in Docker.
2. Run the `DemoKafkaSpringApplication` class to start the Spring Boot application.
3. Use the `/publish/{topic}/{name}` endpoint to generate a `PageEvent` and send it to a Kafka topic.
4. You can use a Docker Compose file to run Kafka in a container for more information, refer to the `info.txt` file.

## Resume

![image](https://github.com/user-attachments/assets/177be4c7-a641-4cf4-b624-2f37cc1b1719)
