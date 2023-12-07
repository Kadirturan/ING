package com.trading.creditchecklimit.managers;



import com.trading.creditchecklimit.service.OrderExecutionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class QueueListener {

    private static QueueListener queueListener = null;

    OrderExecutionService executor = null;

    OrderManager orderManager = OrderManager.getOrderManager();

    public  boolean proccess = false;



    public static QueueListener getQueueListener()
    {
        if(queueListener == null)
            queueListener = new QueueListener();
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
