package com.liujie.java8.stream.test;

import java.util.Currency;

public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
    private Currency currency;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" + "trader=" + trader + ", year=" + year + ", value=" + value + '}';
    }
}
