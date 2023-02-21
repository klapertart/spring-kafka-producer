package klapertart.lab.kafkaproducer;

import klapertart.lab.kafkaproducer.data.KafkaProperties;
import klapertart.lab.kafkaproducer.data.SslProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {
		KafkaProperties.class,
		SslProperties.class
})
public class SpringbootKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaProducerApplication.class, args);
	}

}
