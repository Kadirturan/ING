package com.trading.creditchecklimit;

import com.trading.creditchecklimit.data.InitialData;
import com.trading.creditchecklimit.handler.QueueHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreditchecklimitApplication {

	public static void main(String[] args) {

		InitialData.loadFromFile();
		//InitialData.loadInitialData();







		SpringApplication.run(CreditchecklimitApplication.class, args);



		QueueHandler queueListener = QueueHandler.getQueueListener();
		queueListener.processOrders();


	}

}
