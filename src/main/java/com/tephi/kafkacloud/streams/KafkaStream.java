package com.tephi.kafkacloud.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * To communicate with kafka, an Inbound stream for reading messages and outbound stream for writing messages
 * to be created
 * can be Autowired anywhere it is needed
 */
public interface KafkaStream {

    //The names below and the names in the application.yml for bindings should be the same
    String INPUT = "producer";
    String OUTPUT = "consumer";

    @Input(INPUT)
    SubscribableChannel inboundMessage();

    @Output(OUTPUT)
    MessageChannel outboundMessage();
}
