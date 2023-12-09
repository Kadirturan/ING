package com.trading.creditchecklimit.handler;



import com.trading.creditchecklimit.model.Order;
import com.trading.creditchecklimit.model.SectorLimit;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SectorLimitHandler {

    private static SectorLimitHandler sectorLimitHandler = null;

    OrderHandler orderHandler = OrderHandler.getOrderHandler();

    public static SectorLimitHandler getSectorLimitHandler()
    {
        if(sectorLimitHandler ==null)
            sectorLimitHandler = new SectorLimitHandler();
        return sectorLimitHandler;
    }
    public  Map<String, SectorLimit> sectorLimitMap = new ConcurrentHashMap<>();






    public   boolean checkCreditLimit(Order order) throws Exception{
        SectorLimit limit = sectorLimitMap.get(order.getSector());

        Thread.sleep(200);

        boolean result = false;

        if (limit == null) {

            result = true;
        }
        else {
            if (order.getSide() == 1) //buy order
            {

                if (order.getVolume() <= limit.getRemBuyAmount()) {
                    limit.setBuyAmount(limit.getBuyAmount() + order.getVolume());
                    limit.setRemBuyAmount(limit.getRemBuyAmount() - order.getVolume());
                    order.setStatus("Accept");
                    result = true;
                } else {
                    result = false;
                    order.setStatus("Reject");

                }

            } else if (order.getSide() == 2) //sell order
            {

                if (order.getVolume() <= limit.getRemSellAmount()) {
                    limit.setSellAmount(limit.getSellAmount() + order.getVolume());
                    limit.setRemSellAmount(limit.getRemSellAmount() - order.getVolume());
                    order.setStatus("Accept");
                    result = true;
                } else {
                    result = false;
                    order.setStatus("Reject");
                }
            }


        }

        //orderHandler.getLogger().add(String.format("%-30s", Thread.currentThread().getName()+" executing: ")+String.format("%-80s", order.toString())+" "+limit.toString());
        orderHandler.getLogger().add(Thread.currentThread().getName()+" exec:"+order.toString()+" "+limit.toString(order.getSide()));
        return result;

    }

    public  void printMap()
    {
        for(Map.Entry<String,SectorLimit> enty:sectorLimitMap.entrySet())
        {
            System.out.println(enty.getValue().toString());
        }
    }

    public void addSectorLimits(List<SectorLimit> sectorLimitList)
    {
        for(SectorLimit sectorLimit :sectorLimitList)
        sectorLimitMap.put(sectorLimit.getCode(),sectorLimit);
    }

    public void addSectorLimit(SectorLimit sectorLimit)
    {
        sectorLimitMap.put(sectorLimit.getCode(),sectorLimit);
    }


}
