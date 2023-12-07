package com.trading.creditchecklimit;

import com.trading.creditchecklimit.data.InitialData;
import com.trading.creditchecklimit.managers.QueueListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreditchecklimitApplication {

	public static void main(String[] args) {

		InitialData.loadInitialData();






		SpringApplication.run(CreditchecklimitApplication.class, args);

		QueueListener queueListener = QueueListener.getQueueListener();
		queueListener.processOrders();


	}

}
