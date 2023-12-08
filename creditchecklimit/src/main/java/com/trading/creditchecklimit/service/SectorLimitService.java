package com.trading.creditchecklimit.service;

import com.trading.creditchecklimit.handler.SectorLimitHandler;
import com.trading.creditchecklimit.model.SectorLimit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorLimitService {

    SectorLimitHandler sectorManager = SectorLimitHandler.getSectorManager();
    public List<SectorLimit> getSectorStatus()
    {
        return sectorManager.sectorLimitMap.values().stream().toList();
    }


}
