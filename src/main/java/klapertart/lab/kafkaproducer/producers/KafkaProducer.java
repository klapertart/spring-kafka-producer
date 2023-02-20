package klapertart.lab.kafkaproducer.producers;

import klapertart.lab.kafkaproducer.data.KafkaProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author kurakuraninja
 * @since 20/02/23
 */

@Service
@Slf4j
public class KafkaProducer {

    @Autowired
    @Qualifier("stringKafkaTemplate")
    private KafkaTemplate<String, String> stringKafkaTemplate;

    @Autowired
    @Qualifier("objectKafkaTemplate")
    private KafkaTemplate<String, Object> objectKafkaTemplate;

    @Autowired
    private KafkaProperties kafkaProperties;


    // send string message
    public void sendMessageString(String message){
        long currentMilis = System.currentTimeMillis();
        stringKafkaTemplate.send(kafkaProperties.getTopic(), String.valueOf(currentMilis), message);
        log.info("Message has been sent to topic: {}",message);
    }

    // send object message
    public <T> void sendMessageObject(T object){
        long currentMilis = System.currentTimeMillis();
        objectKafkaTemplate.send(kafkaProperties.getTopic(),String.valueOf(currentMilis),object);
        log.info("Message has been sent to topic: {}",object.toString());
    }
}
