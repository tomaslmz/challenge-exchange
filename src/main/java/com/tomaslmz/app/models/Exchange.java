package com.tomaslmz.app.models;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class Exchange {
  String url = "https://v6.exchangerate-api.com/v6/7c4891d8810fc737e44f57c9/";

  public Currency convert(double amount, String from, String to) {
    try {
      HttpClient client = HttpClient.newHttpClient();

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url + "pair/" + from + "/" + to + "/" + String.valueOf(amount)))
        .build();

      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      Gson gson = new Gson();

      Currency currency = gson.fromJson(response.body(), Currency.class);

      return currency;
    } catch(Exception e) {
      System.err.println(e.getMessage());
      return null;
    }
  }
}
