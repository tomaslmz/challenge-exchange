package com.tomaslmz.app;

import java.util.Scanner;

import com.tomaslmz.app.models.Currency;
import com.tomaslmz.app.models.Exchange;

public class App {
    public static void main( String[] args ) {
      String[] options = {
        "NONE",
        "BRL",
        "USD",
        "EUR",
        "JPY",
        "ARS"
      };

      Scanner sc = new Scanner(System.in);

      int from = -1;

      do {
        System.out.println("Welcome to the Challenge Exchange!");

        System.out.println("Type a number to start to use!");
        System.out.println("""
          1 - BRL
          2 - USD
          3 - EUR
          4 - JPY
          5 - ARS
          0 - To exit the program
        """);
        do {
          from = sc.nextInt();

          if(from < 0 || from > 5) {
            System.out.println("Please, type a valid option!");
          }
        } while(from < 0 || from > 5);

        if(from != 0) {
          System.out.println("Ok! The selected type was " + options[from] + ". Now, you should select another option!");

          int to = -1;

          System.out.println("""
            1 - BRL
            2 - USD
            3 - EUR
            4 - JPY
            5 - ARS
          """);

          do {
            to = sc.nextInt();

            if(to < 0 || to > 5) {
              System.out.println("Please, type a valid option!");
            }

            if(to == from) {
              System.out.println("Please, select a different option!");
            }
          } while(to < 0 || to > 5 || to == from);

        System.out.println("Ok! The conversion will be from " + options[from] + " to " + options[to] + "! Now, you should type an amount!");

          double amount = -1;

          do {
            System.out.print("\nType your amount: ");
            amount = sc.nextDouble();

            if(amount <= 0) {
              System.out.println("Please, type a valid amount!");
            }
          } while(amount <= 0);

          Currency currency = new Currency(options[from], amount);

          System.out.println(currency.getCurrency());

          Exchange exchange = new Exchange();

          System.out.println("\nCONVERTED");

          Currency convertedCurrency = exchange.convert(amount, options[from], options[to]);

          System.out.println(convertedCurrency.getCurrency());
        }
      } while(from != 0);
      sc.close();
    }
}
