package com.codecool.stocktrader.service;

import net.minidev.json.JSONObject;
import org.json.JSONException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StockAPIService {

    private RemoteURLReader remoteURLReader;

    public StockAPIService(RemoteURLReader remoteURLReader) {
        this.remoteURLReader = remoteURLReader;
    }

    private String apiPath = "https://financialmodelingprep.com/api/v3/stock/real-time-price/%s";


    public double getPrice(String symbol) throws IOException, JSONException {
        String url = String.format(apiPath, symbol);
        String result = remoteURLReader.readFromUrl(url);
        JSONObject json = generateJson(result);
        String price = json.get("price").toString();
        return Double.parseDouble(price);


    }

    public boolean buy(String symbol) {
        return true;
    }

    public JSONObject generateJson(String result) throws JSONException {
        return new JSONObject(result);
    }
}
