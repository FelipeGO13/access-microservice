package br.com.mastertech.access.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccessProducer {

        @Autowired
        private KafkaTemplate<String, AccessLog> producer;

        public void sendToKafka(AccessLog accessLog){
            producer.send("spec4-felipe-gabriel-1", accessLog);
        }

}
