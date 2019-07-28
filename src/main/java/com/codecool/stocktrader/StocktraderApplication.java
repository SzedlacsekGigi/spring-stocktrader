package com.codecool.stocktrader;

import com.codecool.stocktrader.service.RemoteURLReader;
import com.codecool.stocktrader.controller.StockTraderController;
import com.codecool.stocktrader.service.Logger;
import com.codecool.stocktrader.service.StockAPIService;
import com.codecool.stocktrader.service.Trader;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class StocktraderApplication {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StocktraderApplication.class);


    @Autowired
    private Logger logger;
    @Autowired
    private RemoteURLReader remoteURLReader;
    @Autowired
    private Trader trader;
    @Autowired
    private StockAPIService stockAPIService;
    @Autowired
    private StockTraderController stockTraderController;

    public static void main(String[] args) {
        SpringApplication.run(StocktraderApplication.class, args);
    }

    @PostConstruct
    public void afterInit(){
        LOGGER.info(logger.toString());
        LOGGER.info(remoteURLReader.toString());
        LOGGER.info(trader.toString());
        LOGGER.info(stockAPIService.toString());
        LOGGER.info(stockTraderController.toString());

    }

}
