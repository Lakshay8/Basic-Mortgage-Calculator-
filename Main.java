package com.lakshay;
import javax.swing.*;
import java.text.NumberFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        final byte percent = 100;
        final byte months = 12;

         System.out.println("The Mortgage Calculator");
        Scanner sc = new Scanner(System.in);

       int principal = 0;
       //for loop
        //System.out.print( "Principal ($ 1K - $ 1M) :");
           // for(int i=0; i < 100; i++){
              //  principal = sc.nextInt();
             //   if (principal >=1000 && principal <=1000000) {
              //  } else
                //    System.out.println("Enter a number between 1,000 and 1,000,000.");

        while (true){
            System.out.print( "Principal ($ 1K - $ 1M) :");
            principal = sc.nextInt();
            if(principal>=1000 && principal <=1000000){
            break;
            } else
                System.out.println("Enter a number between 1,000 and 1,000,000.");
        }
        float Annual_Interest_rate;
        float monthly_interest_rate = 0;
        while (true) {
            System.out.print("Annual Interest Rate:");
            Annual_Interest_rate = sc.nextFloat();
            if (Annual_Interest_rate > 0 && Annual_Interest_rate <= 30) {
                break;
            } else
                System.out.println("Enter a number greater then 0 and less than or equal to 30.");
        }

            monthly_interest_rate = (Annual_Interest_rate / percent) / months;
        int years;
       while (true) {
           System.out.print("periods (Years): ");
           years = sc.nextInt();
           if (years > 0 && years <= 30) {
               break;
           } else
               System.out.println("Enter a value between 1 and 30.");
       }
        int numberOfPayments = years * 12;

        double mortgage = principal * (monthly_interest_rate * Math.pow( 1+ monthly_interest_rate,numberOfPayments)) / (Math.pow(1 + monthly_interest_rate,numberOfPayments) -1 );

        String Mortgage = NumberFormat.getCurrencyInstance().format(mortgage);
       System.out.println("Mortgage:" + Mortgage);


    }
}
