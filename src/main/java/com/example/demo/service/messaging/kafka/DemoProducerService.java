package com.example.demo.service.messaging.kafka;

import com.example.demo.web.model.DemoRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class DemoProducerService {

    private final KafkaTemplate<String, DemoRequest> kafkaTemplate;

    public DemoProducerService(KafkaTemplate<String, DemoRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(DemoRequest demoRequest){
        kafkaTemplate.send("topic.test", demoRequest);
    }
}
