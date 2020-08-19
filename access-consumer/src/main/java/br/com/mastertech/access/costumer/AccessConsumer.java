package br.com.mastertech.access.costumer;

import br.com.mastertech.access.producer.AccessLog;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AccessConsumer {

    @KafkaListener(topics = "spec4-felipe-gabriel-1", groupId = "teste")
    public void receber(@Payload AccessLog accessLog) {
        System.out.println("Recebi o cliente " + accessLog.getCostumerId() + " na porta " + accessLog.getDoorId() + " com acesso: " +  accessLog.getHasAccess());
    }

}
