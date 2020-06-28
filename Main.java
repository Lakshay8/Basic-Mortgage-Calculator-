package com.lakshay;
import java.text.NumberFormat;
import java.util.*;

public class Main {
    final static byte percent = 100;
    final static byte monthsInYear = 12;
    public static void main(String[] args) {
        System.out.println("The Mortgage Calculator");

        int principal = (int) readNumber("Principal (1K - 1M):", 1000, 1000000);
        double Annual_Interest_rate = readNumber("Annual Interest Rate:", 1, 30);
        byte years = (byte) readNumber("Periods (Years):", 1, 30);

        printMortgage(principal, Annual_Interest_rate, years);

        printPaymentSchedule(principal, Annual_Interest_rate, years);
    }

    public static void printMortgage(int principal, double annual_Interest_rate, byte years) {
        double mortgage = mortgageCalculate(principal, annual_Interest_rate, years);
        String Mortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + Mortgage);
    }

    public static void printPaymentSchedule(int principal, double annual_Interest_rate, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * monthsInYear; month++){
            double balance = calculateBalance(principal, annual_Interest_rate,years,month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double calculateBalance(int principal, double Annual_Interest_rate, byte years, int numberOfPaymentsMade){
            float numberOfPayments = years * 12;
            double monthly_interest_rate = (Annual_Interest_rate / percent) / monthsInYear;
            double remainingBalance = principal * (Math.pow(1+monthly_interest_rate, numberOfPayments) - Math.pow(1 + monthly_interest_rate, numberOfPaymentsMade)) / (Math.pow(1+monthly_interest_rate,numberOfPayments)-1);

            return remainingBalance;

    }public static double mortgageCalculate(int principal, double Annual_Interest_rate, byte years) {
        float numberOfPayments = years * 12;
        double monthly_interest_rate = (Annual_Interest_rate / percent) / monthsInYear;
        double mortgage = principal *
                (monthly_interest_rate * Math.pow(1 + monthly_interest_rate, numberOfPayments))
                / (Math.pow(1 + monthly_interest_rate, numberOfPayments) - 1);

        return mortgage;

    }public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print(prompt);
            value = sc.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a number between " + min + "and " + max);
        }
        return value;
    }
}