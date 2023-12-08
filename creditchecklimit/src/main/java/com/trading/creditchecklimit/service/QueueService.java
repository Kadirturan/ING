package com.trading.creditchecklimit.service;

import com.trading.creditchecklimit.handler.QueueHandler;
import org.springframework.stereotype.Service;

@Service
public class QueueService {

    public void start()
    {
        QueueHandler queueListener = QueueHandler.getQueueListener();
        queueListener.start();
    }


}
