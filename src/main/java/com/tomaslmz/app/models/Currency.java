package com.tomaslmz.app.models;

public class Currency {
  private double amount;
  private String type;

  public Currency(String type, double amount) {
    this.type = type;
    this.amount = amount;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getCurrency() {
    return "TYPE: " + type + "\nAMOUNT: " + amount;
  }
}
