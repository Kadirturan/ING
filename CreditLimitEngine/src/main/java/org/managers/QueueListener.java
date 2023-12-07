package org.managers;

import org.service.OrderExecutionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QueueListener {

    private static QueueListener queueListener = null;

    private QueueListener()
    {

    }

    public static QueueListener getQueueListener()
    {
        if(queueListener == null)
            queueListener = new QueueListener();
        return queueListener;
    }

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void start()
    {

        OrderExecutionService executor = null; //new OrderExecutor();

        OrderManager orderManager = OrderManager.getOrderManager();
        while(true)
        {
            executor = new OrderExecutionService(orderManager.getOrderToExecute());//executor.setOrder(orderManager.getOrderToExecute());
            executorService.submit( executor);
        }
    }

    public void shutDown()
    {
        executorService.shutdown();

    }
}
