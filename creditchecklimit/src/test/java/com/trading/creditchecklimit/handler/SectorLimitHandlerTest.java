package com.trading.creditchecklimit.handler;

import com.trading.creditchecklimit.model.Order;
import com.trading.creditchecklimit.model.SectorLimit;
import com.trading.creditchecklimit.service.OrderExecutionService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class SectorLimitHandlerTest {





    @Test
    public void checkOrderEntrySingle() {

       SectorLimitHandler sectorManager = SectorLimitHandler.getSectorLimitHandler();
       List<SectorLimit> sectorLimits = new ArrayList<>();
       SectorLimit sectorLimit = new SectorLimit("Sector1",10000,20);
       sectorLimits.add(sectorLimit);
       sectorManager.addSectorLimits(sectorLimits);

       OrderHandler orderManager = OrderHandler.getOrderHandler();
       List<Order> orderList = new ArrayList<>();
       Order order =  new Order(1,100,"Garan","Sector1","TRD1");
       orderList.add(order );
       orderManager.addOrdersToQueue(orderList);


        ExecutorService executorService = Executors.newFixedThreadPool(1);
        OrderExecutionService executor = new OrderExecutionService(orderManager.getOrderToExecute());
        executorService.submit(executor);

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {

        }



        assertEquals(order.getStatus(),"Accept");

    }


    @Test
    public void checkOrderEntryMultiple() {

        SectorLimitHandler sectorManager = SectorLimitHandler.getSectorLimitHandler();
        List<SectorLimit> sectorLimits = new ArrayList<>();
        SectorLimit sectorLimit = new SectorLimit("Sector1", 5000, 20);
        sectorLimits.add(sectorLimit);
        sectorManager.addSectorLimits(sectorLimits);

        OrderHandler orderHandler = OrderHandler.getOrderHandler();
        List<Order> orderList = new ArrayList<>();
        Order[] orders = new Order[]
                {
                        new Order(1, 100, "Garan", "Sector1", "TRD1"),
                        new Order(1, 2000, "Garan", "Sector1", "TRD1"),
                        new Order(1, 200, "Garan", "Sector1", "TRD1"),
                        new Order(1, 1500, "Garan", "Sector1", "TRD1"),
                        new Order(1, 300, "Garan", "Sector1", "TRD1"),
                        new Order(1, 100, "Garan", "Sector1", "TRD1"),
                        new Order(2, 400, "Garan", "Sector1", "TRD1"),
                        new Order(2, 300, "Garan", "Sector1", "TRD1"),
                        new Order(2, 100, "Garan", "Sector1", "TRD1"),
                        new Order(2, 100, "Garan", "Sector1", "TRD1"),
                        new Order(2, 100, "Garan", "Sector1", "TRD1"),
                        new Order(2, 1500, "Garan", "Sector1", "TRD1"),
                        new Order(2, 1600, "Garan", "Sector1", "TRD1"),


                };

        orderList.addAll(Arrays.stream(orders).toList());
        orderHandler.addOrdersToQueue(orderList);


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (Order order:orderList
             ) {
            OrderExecutionService executor = new OrderExecutionService(orderHandler.getOrderToExecute());
            executorService.submit(executor);

        }


        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {

        }


        assertEquals(orderHandler.getBooked().size(), 9);

    }

}
