package com.trading.creditchecklimit.service;

import com.trading.creditchecklimit.managers.QueueListener;
import org.springframework.stereotype.Service;

@Service
public class QueueService {

    public void start()
    {
        QueueListener queueListener = QueueListener.getQueueListener();
        queueListener.start();
    }


}
