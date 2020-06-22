package com.lakshay;

import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        final byte percent = 100;
        final byte months = 12;
         System.out.println("The Mortgage Calculator");
        Scanner sc = new Scanner(System.in);

        System.out.print("Principal:");
        int principal = sc.nextInt();

        System.out.print("Annual Interest Rate:");
        float Annual_Interest_rate = sc.nextFloat();
        float monthly_interest_rate = (Annual_Interest_rate/percent)/months;

        System.out.print("periods (Years): ");
        int years = sc.nextInt();
        int numberOfPayments = years * 12;

        double mortgage = principal * (monthly_interest_rate * Math.pow( 1+ monthly_interest_rate,numberOfPayments)) / (Math.pow(1 + monthly_interest_rate,numberOfPayments) -1 );

        String Mortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage:" + Mortgage);


    }
}
