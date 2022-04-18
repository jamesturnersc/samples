package test.handlers;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import test.Data;

/**
 * Receives a message over Kafka of {@link Data} 
 *
 */
@Component
public class KafkaConsumer implements Consumer<Data> {

	private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	
	public void accept(Data data) {
		logger.info("Received data {}", data);
		// TODO: actual processing here
	}

}
