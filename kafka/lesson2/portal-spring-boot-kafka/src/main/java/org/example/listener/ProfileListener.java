package org.example.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Component
public class ProfileListener {
    private final ObjectMapper mapper;
    private final ProfileService svc;

    public ProfileListener(ObjectMapper mapper,
                           ProfileService svc) {
        this.mapper = mapper;
        this.svc = svc;
    }

    @KafkaListener(topics = "portal-topic", groupId = "portal-group-1")
    @Transactional(transactionManager = "kafkaTransactionManager")
    public void listen(String profileStr, Acknowledgment ack) throws IOException {
        var profile = mapper.readValue(profileStr, Profile.class);
        svc.saveProfile(profile);
        if (profile.getAge() > 55) {
            ack.acknowledge();
        }
        //some logic
    }

}
