package klapertart.lab.kafkaproducer.controller;

import klapertart.lab.kafkaproducer.data.User;
import klapertart.lab.kafkaproducer.producers.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kurakuraninja
 * @since 20/02/23
 */

@Slf4j
@RestController
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/messages/{message}")
    public String getMessage(@PathVariable String message){
        log.info("Receive message: {}", message);
        kafkaProducer.sendMessageString(message);
        return "Message has been sent to kafka.";
    }

    @PostMapping("/messages")
    public String getObject(@RequestBody User user){
        log.info("Receive message object : {}", user.toString());
        kafkaProducer.sendMessageObject(user);
        return "Message has been sent to kafka.";
    }
}
