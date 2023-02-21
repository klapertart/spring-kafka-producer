package klapertart.lab.kafkaproducer.producers;

import klapertart.lab.kafkaproducer.properties.KafkaProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author kurakuraninja
 * @since 20/02/23
 */


@Service
@Slf4j
public class KafkaProducer{

    @Autowired
    @Qualifier("stringKafkaTemplate")
    private KafkaTemplate<String, String> stringKafkaTemplate;

    @Autowired
    @Qualifier("objectKafkaTemplate")
    private KafkaTemplate<String, Object> objectKafkaTemplate;

    @Autowired
    private KafkaProperties kafkaProperties;


    // send string message
    public void sendStringMessage(String message){
        long currentMilis = System.currentTimeMillis();
        stringKafkaTemplate.send(kafkaProperties.getTopic(), String.valueOf(currentMilis), message);
        log.info("String Message has been sent: {}",message);
    }

    // send object message
    public <T> void sendObjectMessage(T object) {
        long currentMilis = System.currentTimeMillis();
        objectKafkaTemplate.send(kafkaProperties.getTopic(),String.valueOf(currentMilis),object);
        log.info("Object Message has been sent: {}",object.toString());
    }
}
