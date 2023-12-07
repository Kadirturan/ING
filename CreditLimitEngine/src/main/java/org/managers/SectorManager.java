package org.managers;

import org.model.Order;
import org.model.SectorLimit;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SectorManager {
    public static Map<String, SectorLimit> sectorLimitMap = new ConcurrentHashMap<>();



    static {
        sectorLimitMap.put("Banking",new SectorLimit("Banking",1000000L,0L,0L,20));
        sectorLimitMap.put("Food",new SectorLimit("Food",150000L,0L,0L,30));
        sectorLimitMap.put("Health",new SectorLimit("Health",200000L,0L,0L,25));


    }


    public static  boolean checkCreditLimit(Order order)
    {
        SectorLimit limit = sectorLimitMap.get(order.getSector());
        if(limit==null)
            return true;
        else {
            if(order.getSide()==1) //buy order
            {
                float buyPercentage = ((float)(order.getVolume()+limit.getBuyAmount())/limit.getTotalValue())*100;
                if(buyPercentage<limit.getAllowedRate())
                {
                    limit.setBuyAmount(limit.getBuyAmount()+order.getVolume());
                    return true;
                }
                else
                    return false;
            }
            else if(order.getSide()==2) //sell order
            {
                float sellPercentage = ((float)(order.getVolume()+limit.getSellAmount())/limit.getTotalValue())*100;
                if(sellPercentage<limit.getAllowedRate())
                {
                    limit.setSellAmount(limit.getSellAmount()+order.getVolume());
                    return true;
                }
                else
                    return false;
            }
            return false;

        }

    }

    public static void printMap()
    {
        for(Map.Entry<String,SectorLimit> enty:sectorLimitMap.entrySet())
        {
            System.out.println(enty.getValue().toString());
        }
    }


}
