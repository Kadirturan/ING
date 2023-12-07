package org.example;

import org.managers.OrderManager;
import org.managers.QueueListener;
import org.model.Order;

public class Main {
    public static void main(String[] args) {
        //SectorManager.printMap();
        //ExecutorService executorService = Executors.newFixedThreadPool(10);
        //OrderExecutor executor = new OrderExecutor();

        OrderManager orderManager = OrderManager.getOrderManager();

        for(int i=0;i<50;i++)
        {
            orderManager.addOrderToQueue(new Order(1,i+1+i*10,"ABC"+i,"Banking","trd"));
        }

        QueueListener listener = QueueListener.getQueueListener();
        listener.start();
        listener.shutDown();

        /*while(!OrderManager.isQueueEmpty())
        {
            executorService.submit(new OrderExecutor(OrderManager.getOrderToExecute()));
        }
       // Future<Boolean> sumResult = executorService.submit(new OrderExecutor(new Order(1,10000,"YKBNK","Banking","Trader")));
       /* try {
            System.out.println(sumResult.get().booleanValue());
            executorService.submit(new OrderExecutor(new Order(1,10000,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10001,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10002,"YKBNK","Banking","Trader")));
            SectorManager.printMap();
            executorService.submit(new OrderExecutor(new Order(1,10003,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10004,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10005,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10006,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10007,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10008,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10009,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10010,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10011,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10012,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10013,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10014,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10015,"YKBNK","Banking","Trader")));
            SectorManager.printMap();
            executorService.submit(new OrderExecutor(new Order(1,10016,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10017,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10018,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10019,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10020,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10021,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10022,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10023,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10024,"YKBNK","Banking","Trader")));
            SectorManager.printMap();
            executorService.submit(new OrderExecutor(new Order(1,10025,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10026,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10027,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10028,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10029,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10030,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10031,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10032,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10033,"YKBNK","Banking","Trader")));
            executorService.submit(new OrderExecutor(new Order(1,10034,"YKBNK","Banking","Trader")));
        }
        catch (Exception exception)
        {

        }
        /**/
       // executorService.shutdown();
    }
}