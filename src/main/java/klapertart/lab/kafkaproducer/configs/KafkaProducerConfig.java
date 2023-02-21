package klapertart.lab.kafkaproducer.configs;

import klapertart.lab.kafkaproducer.properties.HttpsProperties;
import klapertart.lab.kafkaproducer.properties.KafkaProperties;
import klapertart.lab.kafkaproducer.properties.SslProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.security.plain.PlainLoginModule;
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

@Slf4j
@Configuration
public class KafkaProducerConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Autowired
    private SslProperties sslProperties;

    @Autowired
    private HttpsProperties httpsProperties;


    @Bean
    public ProducerFactory<String,String> stringProducerFactory(){

        Map<String,Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        if(sslProperties.isEnabled()) {
            configs.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
            configs.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, sslProperties.getTruststore().getLocation());
            configs.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, sslProperties.getTruststore().getPassword());
            configs.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, sslProperties.getKeystore().getLocation());
            configs.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, sslProperties.getKeystore().getPassword());
            configs.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, sslProperties.getKey().getPassword());
            configs.put(SslConfigs.SSL_ENDPOINT_IDENTIFICATION_ALGORITHM_CONFIG, "");
            configs.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
            configs.put(SaslConfigs.SASL_JAAS_CONFIG, PlainLoginModule.class.getName() + " required username=\"" + sslProperties.getJaas().getUsername() + "\" password=\"" + sslProperties.getJaas().getPassword() + "\";");
        }

        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    public ProducerFactory<String, ?> objectProducerFactory(){
        Map<String,Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaProperties.getBootstrapServers());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        if(sslProperties.isEnabled()) {
            configs.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
            configs.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, sslProperties.getTruststore().getLocation());
            configs.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, sslProperties.getTruststore().getPassword());
            configs.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, sslProperties.getKeystore().getLocation());
            configs.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, sslProperties.getKeystore().getPassword());
            configs.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, sslProperties.getKey().getPassword());
            configs.put(SslConfigs.SSL_ENDPOINT_IDENTIFICATION_ALGORITHM_CONFIG, "");
            configs.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
            configs.put(SaslConfigs.SASL_JAAS_CONFIG, PlainLoginModule.class.getName() + " required username=\"" + sslProperties.getJaas().getUsername() + "\" password=\"" + sslProperties.getJaas().getPassword() + "\";");
        }

        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    public KafkaTemplate<String,String> stringKafkaTemplate(){
        return new KafkaTemplate<>(stringProducerFactory());
    }

    @Bean
    public KafkaTemplate<String,?> objectKafkaTemplate(){
        return new KafkaTemplate<>(objectProducerFactory());
    }

}
