package com.tephi.kafkacloud.service;

import com.tephi.kafkacloud.model.Message;
import com.tephi.kafkacloud.streams.KafkaStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaMessageListener {

    @StreamListener(KafkaStream.INPUT)
    public void getKafkaMessage(@Payload Message message){
        log.info("Received message : {}", message);
    }
}
