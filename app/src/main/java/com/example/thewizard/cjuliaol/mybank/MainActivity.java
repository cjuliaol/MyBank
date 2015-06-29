package com.example.thewizard.cjuliaol.mybank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;

import com.example.thewizard.cjuliaol.accounts.BankAccount;
import com.example.thewizard.cjuliaol.accounts.CheckingAccount;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity";
    private EditText mAmountInput;
    private Button mWithdrawButton;
    private Button mDepositButton;
    private TextView mBalanceDisplay;
    private BankAccount mBankAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] array = new int[4];
        array[0]= 100;
        array[1]= 200;
        array[2]= 300;
        array[3]= 100;

        Log.d(TAG,"Array[2] is "+ array[2]);

        String[] stringArray = new String[2];
        stringArray[1] ="Viva la vida!";
        Log.d(TAG,stringArray[0] + " " +stringArray[1]);


        Log.d(TAG,"Overdraft Fee is " + mBankAccount.OVERDRAFTFEE);


        mAmountInput = (EditText) findViewById(R.id.amount_input);
        mWithdrawButton = (Button) findViewById(R.id.withdraw_button);
        mDepositButton = (Button) findViewById(R.id.deposit_button);
        mBalanceDisplay = (TextView) findViewById(R.id.balance_display);
        mBankAccount = new CheckingAccount();

        mWithdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = mAmountInput.getText().toString();
                mBankAccount.withdraw(Double.parseDouble(amount));
                mBalanceDisplay.setText("Current balance is: " + mBankAccount.getBalance());

            }
        });

        mDepositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = mAmountInput.getText().toString();
                mBankAccount.deposit(Double.parseDouble(amount));
                mBalanceDisplay.setText("Current balance is: " + mBankAccount.getBalance());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
