package com.trading.creditchecklimit.service;

import com.trading.creditchecklimit.managers.SectorLimitManager;
import com.trading.creditchecklimit.model.SectorLimit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorLimitService {

    SectorLimitManager sectorManager = SectorLimitManager.getSectorManager();
    public List<SectorLimit> getSectorStatus()
    {
        return sectorManager.sectorLimitMap.values().stream().toList();
    }


}
