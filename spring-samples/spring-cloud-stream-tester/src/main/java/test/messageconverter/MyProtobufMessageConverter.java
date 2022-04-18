package test.messageconverter;



import org.springframework.messaging.converter.ProtobufMessageConverter;
import org.springframework.stereotype.Component;

/**
 * Per https://stackoverflow.com/questions/70121156/how-to-use-org-springframework-messaging-converter-protobufmessageconverter
 * 
 * There is a ProtobufMessageConverter defined in Spring and is used with content type of application/x-protobuf,
 * however it filtered out so need to subclass and define as a bean so it will be used.
 */
@Component
public class MyProtobufMessageConverter extends ProtobufMessageConverter {

}