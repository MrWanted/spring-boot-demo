package com.example.springbootdemo.api.rest.controllers;

import com.example.springbootdemo.api.service.KafkaProducerService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Data
@RequestMapping("/rest/api/events")
@RestController
public class EventProducerController {
    private final KafkaProducerService service;

    @GetMapping("/publish/{message}")
    public ResponseEntity publish(@PathVariable String message){
        service.sendMessage(message);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
}
