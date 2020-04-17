package com.tephi.kafkacloud.config;

import com.tephi.kafkacloud.streams.KafkaStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * Spring Cloud Stream to bind to our streams in the KafkaStreams interface.
 */
@EnableBinding(KafkaStream.class)
public class KafkaStreamConfig {
}
