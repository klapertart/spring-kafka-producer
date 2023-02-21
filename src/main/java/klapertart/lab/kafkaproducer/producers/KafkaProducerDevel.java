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
 * @since 21/02/23
 */

@Service
@Slf4j
@Profile("devel")
public class KafkaProducerDevel implements KafkaProducer{

    @Autowired
    @Qualifier("stringKafkaTemplateDevel")
    private KafkaTemplate<String, String> stringKafkaTemplateDevel;

    @Autowired
    @Qualifier("objectKafkaTemplateDevel")
    private KafkaTemplate<String, Object> objectKafkaTemplateDevel;

    @Autowired
    private KafkaProperties kafkaProperties;

    @Override
    public void sendStringMessage(String message) {
        long currentMilis = System.currentTimeMillis();
        stringKafkaTemplateDevel.send(kafkaProperties.getTopic(), String.valueOf(currentMilis), message);
        log.info("Message has been sent to topic: {}",message);
    }

    @Override
    public <T> void sendObjectMessage(T object) {
        long currentMilis = System.currentTimeMillis();
        objectKafkaTemplateDevel.send(kafkaProperties.getTopic(),String.valueOf(currentMilis),object);
        log.info("Message has been sent to topic: {}",object.toString());
    }
}
