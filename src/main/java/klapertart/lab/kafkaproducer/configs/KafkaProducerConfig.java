package klapertart.lab.kafkaproducer.configs;

import klapertart.lab.kafkaproducer.properties.KafkaProperties;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kurakuraninja
 * @since 20/02/23
 */

@Configuration
public class KafkaProducerConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    @Profile("local")
    public ProducerFactory<String,String> stringProducerFactoryLocal(){
        Map<String,Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    @Profile("local")
    public ProducerFactory<String, ?> objectProducerFactoryLocal(){
        Map<String,Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaProperties.getBootstrapServers());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    @Profile("local")
    public KafkaTemplate<String,String> stringKafkaTemplateLocal(){
        return new KafkaTemplate<>(stringProducerFactoryLocal());
    }

    @Bean
    @Profile("local")
    public KafkaTemplate<String,?> objectKafkaTemplateLocal(){
        return new KafkaTemplate<>(objectProducerFactoryLocal());
    }


    @Bean
    @Profile("devel")
    public ProducerFactory<String,String> stringProducerFactoryDevel(){
        Map<String,Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    @Profile("devel")
    public ProducerFactory<String, ?> objectProducerFactoryDevel(){
        Map<String,Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaProperties.getBootstrapServers());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    @Profile("devel")
    public KafkaTemplate<String,String> stringKafkaTemplateDevel(){
        return new KafkaTemplate<>(stringProducerFactoryDevel());
    }

    @Bean
    @Profile("devel")
    public KafkaTemplate<String,?> objectKafkaTemplateDevel(){
        return new KafkaTemplate<>(objectProducerFactoryDevel());
    }

}
