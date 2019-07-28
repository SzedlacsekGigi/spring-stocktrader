package com.codecool.stocktrader.controller;

import com.codecool.stocktrader.service.Trader;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class StockTraderController {

    @Autowired
    private Trader trader;

    @GetMapping("/buy/{stock}/{price}")
    public String buyStock(@PathVariable("stock") String stock, @PathVariable("price") double price) throws IOException, JSONException {
        try {
            boolean purchased = trader.buy(stock, price);
            if (purchased) {
                return "Purchased stock!";
            } else {
                return "Couldn't buy the stock at that price.";
            }
        } catch (Exception e) {
            return "There was an error while attempting to buy the stock: " + e.getMessage();
        }
    }
}