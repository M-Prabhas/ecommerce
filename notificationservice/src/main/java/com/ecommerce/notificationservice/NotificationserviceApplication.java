package com.ecommerce.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationserviceApplication.class, args);
	}

	@kafkalistener(topics = "notificationTopic", groupId = "notificationGroup")
	public void handleNotification(OrderPlacedEvent orderPlacedEvent){
		log.info("Received notification for order number: {}", orderPlacedEvent.getOrderNumber());
		// Implement your notification logic here (e.g., send email, SMS, etc.)		

}
}