package test.producer;

import java.util.UUID;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import test.Data;

/**
 * Sends a message over Kafka of {@link Data} every second
 */
@Component
public class KafkaDataProducer implements Supplier<Data> {

	private static Logger logger = LoggerFactory.getLogger(KafkaDataProducer.class);
	
	// Per https://docs.spring.io/spring-cloud-stream/docs/3.1.0/reference/html/spring-cloud-stream.html#spring_cloud_function
	// Function and Consumer are pretty straightforward when it comes to how their invocation is triggered.
    // They are triggered based on data (events) sent to the destination they are bound to. In other words,
	// they are classic event-driven components.
	//
	// However, Supplier is in its own category when it comes to triggering. Since it is, by definition, 
	// the source (the origin) of the data, it does not subscribe to any in-bound destination and, therefore, 
	// has to be triggered by some other mechanism(s). There is also a question of Supplier implementation,
	// which could be imperative or reactive and which directly relates to the triggering of such suppliers.
	
	// The Supplier produces a Data whenever its get() method is invoked. However, who invokes this method
	// and how often? The framework provides a default polling mechanism (answering the question of "Who?") 
	// that will trigger the invocation of the supplier and by default it will do so every second (answering 
	// the question of "How often?"). In other words, the above configuration produces a single message every
	// second and each message is sent to an output destination that is exposed by the binder

	public Data get() {
		Data data = Data.newBuilder()
				.setData(UUID.randomUUID().toString())
				.build();
		logger.info("Sending data {}", data);
		return data;
	}

}
