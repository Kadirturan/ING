package com.trading.creditchecklimit.handler;



import com.trading.creditchecklimit.service.OrderExecutionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QueueHandler {

    private static QueueHandler queueListener = null;

    OrderExecutionService executor = null;

    OrderHandler orderManager = OrderHandler.getOrderHandler();

    public  boolean proccess = false;



    public static QueueHandler getQueueListener()
    {
        if(queueListener == null)
            queueListener = new QueueHandler();
        return queueListener;
    }

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void processOrders() {


        while (true) {
            if (proccess) {
                if (!orderManager.isQueueEmpty()) {

                    executor = new OrderExecutionService(orderManager.getOrderToExecute());
                     executorService.submit(executor);
                }
            }


        }

    }


    public void start() {
        this.proccess = true;
    }


}
