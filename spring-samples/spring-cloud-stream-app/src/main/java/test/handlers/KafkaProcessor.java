package test.handlers;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import test.Request;
import test.Response;

/**
 * Receives a message over Kafka of {@link Request} returns with Kafka message of {@link Response}
 *
 */
@Component
public class KafkaProcessor implements Function<Request, Response> {

	private static Logger logger = LoggerFactory.getLogger(KafkaProcessor.class);
	
	public Response apply(Request request) {
		logger.info("Received request {}", request);
		// TODO: actual processing here
		
		Response response = Response.newBuilder()
				.setId(4)
				.setStatus("Accepted")
				.build();
		return response;
	}

}
