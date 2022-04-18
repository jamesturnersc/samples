package test;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;

import test.producer.KafkaDataProducer;

/**
 * Spring Boot entry point for the Kafka test sender
 */
@SpringBootApplication
public class SampleKafkaProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SampleKafkaProducerApplication.class, args);
	}
	
	@Autowired
	private StreamBridge streamBridge;
	
	public void run(String... args) throws Exception {
		
		// Can use StreamBridge to send a single Kafka message using Spring Cloud Stream abstraction
		Request request = Request.newBuilder()
				.setId(12)
				.build();
		streamBridge.send("kafkaRequestProducer-out-0", request);
	}
}
