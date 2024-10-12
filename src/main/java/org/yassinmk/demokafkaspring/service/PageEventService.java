package org.yassinmk.demokafkaspring.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.yassinmk.demokafkaspring.entitie.PageEvent;

import java.util.function.Consumer;

@Service
public class PageEventService {
    @Bean
    public Consumer<PageEvent> pageEventConsumer() {
        return (input) -> {
            System.out.println("-------------------------------");
            System.out.println("PageEvent: " + input.getName());
            System.out.println("-------------------------------");

        };
    }
}
