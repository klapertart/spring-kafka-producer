package klapertart.lab.kafkaproducer;

import klapertart.lab.kafkaproducer.properties.HttpsProperties;
import klapertart.lab.kafkaproducer.properties.KafkaProperties;
import klapertart.lab.kafkaproducer.properties.SslProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {
		KafkaProperties.class,
		SslProperties.class,
		HttpsProperties.class
})
public class SpringbootKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaProducerApplication.class, args);
	}

}
