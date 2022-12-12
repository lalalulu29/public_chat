package ru.kirill98.public_chat;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PublicChatApplication {
	static Logger log = Logger.getLogger(PublicChatApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(PublicChatApplication.class, args);
		log.info("Start app");
	}

}
