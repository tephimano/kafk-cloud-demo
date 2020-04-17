package com.tephi.kafkacloud.controller;

import com.tephi.kafkacloud.model.Message;
import com.tephi.kafkacloud.service.KafkaMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * to trigger sending a message to kafka
 */

@RestController
public class KafkaMessageController {

    private final KafkaMessageService kafkaMessageService;


    public KafkaMessageController(KafkaMessageService kafkaMessageService) {
        this.kafkaMessageService = kafkaMessageService;
    }

    @GetMapping("/message")
    public void getMessage(@RequestParam String paramMessage) {
        Message message = Message.builder().message(paramMessage).timestamp(System.currentTimeMillis()).build();
        kafkaMessageService.sendMessage(message);
    }
}
