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
@Profile("local")
public class KafkaProducerLocal implements KafkaProducer{

    @Autowired
    @Qualifier("stringKafkaTemplateLocal")
    private KafkaTemplate<String, String> stringKafkaTemplateLocal;

    @Autowired
    @Qualifier("objectKafkaTemplateLocal")
    private KafkaTemplate<String, Object> objectKafkaTemplateLocal;

    @Autowired
    private KafkaProperties kafkaProperties;


    // send string message
    @Override
    public void sendStringMessage(String message){
        long currentMilis = System.currentTimeMillis();
        stringKafkaTemplateLocal.send(kafkaProperties.getTopic(), String.valueOf(currentMilis), message);
        log.info("Message has been sent to topic: {}",message);
    }

    // send object message
    @Override
    public <T> void sendObjectMessage(T object) {
        long currentMilis = System.currentTimeMillis();
        objectKafkaTemplateLocal.send(kafkaProperties.getTopic(),String.valueOf(currentMilis),object);
        log.info("Message has been sent to topic: {}",object.toString());
    }
}
