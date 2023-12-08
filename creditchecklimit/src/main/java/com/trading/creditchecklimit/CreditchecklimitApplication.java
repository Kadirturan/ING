package com.trading.creditchecklimit;

import com.trading.creditchecklimit.data.InitialData;
import com.trading.creditchecklimit.handler.QueueHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreditchecklimitApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(CreditchecklimitApplication.class, args);


	}

	/**
	 * Initial data load and thread pool starts listen order wait queue
	 * @param args incoming main method arguments
	 */
	@Override
	public void run(String... args) {
		InitialData.loadFromFile();
		QueueHandler queueListener = QueueHandler.getQueueListener();
		queueListener.processOrders();


	}

}
