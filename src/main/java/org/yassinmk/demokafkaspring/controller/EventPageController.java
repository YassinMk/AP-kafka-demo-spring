package org.yassinmk.demokafkaspring.controller;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.yassinmk.demokafkaspring.entitie.PageEvent;

import java.util.Date;
import java.util.Random;

@RestController
public class EventPageController {
    private StreamBridge streamBridge;

    public EventPageController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @GetMapping("/publish/{topic}/{name}")
    public PageEvent generatePageEvent(@PathVariable String topic, @PathVariable  String name) {
        PageEvent pageEvent = new PageEvent(name ,Math.random()>0.5 ? "U1":"U2" , new Date(), new Random().nextInt(1000));
        streamBridge.send(topic, pageEvent);
        return pageEvent;
    }
}
