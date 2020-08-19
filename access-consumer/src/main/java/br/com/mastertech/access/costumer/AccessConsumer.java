package br.com.mastertech.access.costumer;

import br.com.mastertech.access.producer.AccessLog;
import com.opencsv.CSVWriter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;

@Component
public class AccessConsumer {

    public static final String CSV_FILE_NAME = "csv_access_log.csv";

    @KafkaListener(topics = "spec4-felipe-gabriel-1", groupId = "teste")
    public void receber(@Payload AccessLog accessLog) throws IOException {

          CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE_NAME));
          String accessData = new StringBuilder()
                  .append(accessLog.getCostumerId())
                  .append(",")
                  .append(accessLog.getDoorId())
                  .append(",")
                  .append(accessLog.getHasAccess()).toString();

          writer.writeNext(accessData.split(","));
          writer.close();

    }

}
