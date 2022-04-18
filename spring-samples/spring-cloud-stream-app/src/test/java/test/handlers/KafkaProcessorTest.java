package test.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import test.Request;
import test.Response;
import test.Request.Builder;

/**
 * Unit test for {@link KafkaProcessor}
 * Since ordinary Function, doesn't need Mock or SpringBootTest
 */
public class KafkaProcessorTest {
	
	/**
	 * What is being tested
	 */
	private KafkaProcessor kafkaProcessor;
	
	// Test data
	private Request request;
		
	@BeforeEach
	public void init() {
		kafkaProcessor = new KafkaProcessor();
		request = Request.newBuilder()
				.setId(3)
				.build();
	}

	@Test
	public void test() {
		Response response = kafkaProcessor.apply(request);
		assertNotNull(response);
	}

}
