package com.example.thewizard.cjuliaol.accounts;

import java.util.ArrayList;

/**
 * Created by cjuliaol on 21/06/2015.
 */
public abstract class  BankAccount {

    private double mBalance;
    public static final double OVERDRAFTFEE = 30;
    private ArrayList<Double> mTransactions;




    BankAccount(){
        mTransactions = new ArrayList<Double>();
    }

    public void withdraw(double amount) {



        mTransactions.add(-amount);


        if (getBalance() < 0) {
            mTransactions.add(-OVERDRAFTFEE);
        }
    }

    public void deposit(double amount) {
        mTransactions.add(amount);
    }

    public double getBalance() {
        double total = 0;
        for (int i = 0; i < mTransactions.size(); i++) {
            total += mTransactions.get(i);
        }

        return total;
    }

    protected int numberOfWithdrawals() {
        int count = 0;

        for (int i = 0; i < mTransactions.size(); i++) {
            if (mTransactions.get(i) < 0) {
                count++;
            }
        }

        return count;
    }
}
