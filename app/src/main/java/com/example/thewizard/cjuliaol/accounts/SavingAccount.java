package com.example.thewizard.cjuliaol.accounts;

import com.example.thewizard.cjuliaol.accounts.BankAccount;

/**
 * Created by cjuliaol on 23/06/2015.
 */
public class SavingAccount extends BankAccount {

    @Override
    public void withdraw(double amount) {
        if (numberOfWithdrawals() >= 3) {
            return;
        }
        super.withdraw(amount);
    }
}
