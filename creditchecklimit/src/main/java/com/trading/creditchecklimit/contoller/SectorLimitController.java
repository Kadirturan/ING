package com.trading.creditchecklimit.contoller;

import com.trading.creditchecklimit.data.InitialData;
import com.trading.creditchecklimit.model.Order;
import com.trading.creditchecklimit.model.SectorLimit;
import com.trading.creditchecklimit.service.SectorLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/sector")
public class SectorLimitController {
    @Autowired
    SectorLimitService sectorLimitService;

    @GetMapping( value = "/status",  produces = "application/json")
    public List<SectorLimit> getAllSectors() {

        return sectorLimitService.getSectorStatus();
    }


}
