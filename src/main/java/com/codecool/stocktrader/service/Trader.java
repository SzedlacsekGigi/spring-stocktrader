package com.codecool.stocktrader.service;

import org.json.JSONException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Trader {

    private Logger logger;
    private StockAPIService stockService;

    private Trader(Logger logger, StockAPIService stockService) {
        this.stockService = stockService;
        this.logger = logger;
    }

    public boolean buy(String symbol, double bid) throws IOException, JSONException {
        double price = stockService.getPrice(symbol);

        boolean result;
        if (price <= bid) {
            result = true;
            stockService.buy(symbol);
            logger.log("Purchased " + symbol + " stock at $" + bid + ", since its higher that the current price ($" + price + ")");
        }
        else {
            logger.log("Bid for " + symbol + " was $" + bid + " but the stock price is $" + price + ", no purchase was made.");
            result = false;
        }
        return result;
    }

}