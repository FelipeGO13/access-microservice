package br.com.mastertech.door;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DoorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoorApplication.class, args);
	}

}
