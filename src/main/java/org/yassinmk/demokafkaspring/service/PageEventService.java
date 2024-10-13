package org.yassinmk.demokafkaspring.service;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.yassinmk.demokafkaspring.entitie.PageEvent;

import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class PageEventService {
    private StreamBridge streamBridge ;
    @Bean
    public Consumer<PageEvent> pageEventConsumer() {
        return (input) -> {
            System.out.println("-------------------------------");
            System.out.println("PageEvent: " + input.toString());
            System.out.println("-------------------------------");

        };
    }

    @Bean
    public Supplier<PageEvent> pageEventSupplier(){
        return () -> new PageEvent(
                Math.random() > 0.5 ? "P1" : "P3",
                Math.random() > 0.5 ? "U2" : "U3",
                new Date(),
                new Random().nextInt(9000)
        );
    }

    @Bean
    public Function<PageEvent , PageEvent> pageEventFunction(){
        return (input)->{
            input.setName("UU3");
            input.setPage("50");
            return  input;
        };
    }
}
