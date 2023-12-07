package com.trading.creditchecklimit.data;

import com.trading.creditchecklimit.managers.OrderManager;
import com.trading.creditchecklimit.managers.SectorLimitManager;
import com.trading.creditchecklimit.model.Order;
import com.trading.creditchecklimit.model.SectorLimit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class InitialData {

     static String []securityList = new String[]{"AKBNK","YKBNK","GARAN","ISBNK"};
    static String []sectorList = new String[]{"Health","Banking","Food"};

    static String []traderList = new String[]{"TRD1","TRD2","TRD3"};

    static Random random = new Random();

    public static List<SectorLimit> sectorLimitList =  Arrays.asList(
            new SectorLimit(sectorList[0],random.nextInt(100000,500000),0,0,random.nextInt(25,70)),
            new SectorLimit(sectorList[1],random.nextInt(100000,500000),0,0,random.nextInt(25,70)),
            new SectorLimit(sectorList[2],random.nextInt(100000,500000),0,0,random.nextInt(25,70)));

    public static List<Order> getInitialOrders()
    {
        List<Order> orderList = new ArrayList<>();


        for(int i=0;i<100;i++)
        {
            orderList.add(new Order(
                  random.nextInt(1,2),
                  random.nextInt(1000,100000),
                    securityList[random.nextInt(0,securityList.length)],
                    sectorList[random.nextInt(0,sectorList.length)],
                    traderList[random.nextInt(0,traderList.length)]
            ));
        }

        return orderList;
    }

    public static void loadInitialData()
    {
        SectorLimitManager sectorManager = SectorLimitManager.getSectorManager();
        sectorManager.addSectorLimits(sectorLimitList);
        OrderManager orderManager = OrderManager.getOrderManager();
        orderManager.addOrdersToQueue(getInitialOrders());
    }


}
