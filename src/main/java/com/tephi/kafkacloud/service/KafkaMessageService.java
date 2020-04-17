package com.tephi.kafkacloud.service;

import com.tephi.kafkacloud.model.Message;
import com.tephi.kafkacloud.streams.KafkaStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

/**
 * the service class will write a message to the message topic
 */
@Service
@Slf4j
public class KafkaMessageService {
    private final KafkaStream kafkaStream;

    public KafkaMessageService(KafkaStream kafkaStream) {
        this.kafkaStream = kafkaStream;
    }

    public void sendMessage(final Message message){
        log.info("Sending Message : {}", message);
        MessageChannel messageChannel = kafkaStream.outboundMessage();
        messageChannel.send(MessageBuilder
                .withPayload(message)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}
