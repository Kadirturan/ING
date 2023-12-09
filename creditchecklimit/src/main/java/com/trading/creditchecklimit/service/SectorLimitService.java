package com.trading.creditchecklimit.service;

import com.trading.creditchecklimit.handler.SectorLimitHandler;
import com.trading.creditchecklimit.model.SectorLimit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorLimitService {

    SectorLimitHandler sectorLimitHandler = SectorLimitHandler.getSectorLimitHandler();
    public List<SectorLimit> getSectorStatus()
    {
        return sectorLimitHandler.sectorLimitMap.values().stream().toList();
    }


}
