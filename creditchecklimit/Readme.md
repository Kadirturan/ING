# Credit Check Limit Engine

Checks limit control for each order.

## Description

En application that checks available limit for each order entry concurrently based on the remaining limit .

## Componenets

### controller

#### OrderController

##### enterOrder
    Accept order via rest service and write it to the wait que to be executed 
##### getAllOrders
    Retrieve all orders in wait queue 
##### getAllBookings
    Retrieve all accepted order which passes check limit controll 
##### getAllLogs
    Retrieve all order whetever fail or ucces with remaining seector limit 
    and executed thread info 



#### QueueController
##### start
    Sends start signal to engine to start executing waiting orders 

#### SectorLimitController
##### getAllSectors
    Retrieve current status of all sector with limit info 

### data
##### InitialData
    Loads inital sector limits and sample orders to be excuted from files or with random values

### handler
##### OrderHandler
    Single container for order operations 
    * add order to waiting queue (syncronized)
    * get order from que (syncronized)
    * book accepted orders
    * collect orders for rest services

##### QueueHandler
    Single container for que operations which start to listen queue
    if queue have waiting order it create new worker thread and initiate limit check

##### SectorLimitHandler
    Single container for sectorlimit map checks if sector has available limit for executing order

### model
##### Order
    orderNo : auto generated field to identify each order
    side : 1- buy,2- sell
    volume:order accepted or rejected based on that quantity
    security:security code
    sector:sector of security limit check based on sector
    trader: sender of order
    status: accept/reject
##### SectorLimit
    code:sector code
    totalValue: total value of sector if allow rate is %100 all amount will be used
    buyAmount: total booked buy amount for the sector
    remBuyAmount : remainig buy amount for sector
    sellAmount: total booked sell amount  sector
    remSellAmount : remainig sell amount for sector
    allowedRate : percentage of totalValue of sector to use. it is same for buy and sell
### service
### OrderExecutionService
    service class for attaching single order with a waiting thread 
    and execute check limit concurrently
### OrderService 
    Service layer for order operations:add,retrieve ..
### QueueService
    Service layer for queue operations:startlisten
### SectorLimitService 
    Service layer for sectorlimit operations:retrievestatus




      









### resources

* order.csv : sample orders to fill waiting que
* sector.csv : sample sector for limit check

# Unit Test
### SectorLimitHandlerTest
##### checkOrderEntrySingle
    Create new single order and sector limit and excute limit check
##### checkOrderEntryMultiple
    Create multiple orders and sector limit and excute limit check




github repo link
* [fvcproductions](https://gist.github.com/fvcproductions/1bfc2d4aecb01a834b46)