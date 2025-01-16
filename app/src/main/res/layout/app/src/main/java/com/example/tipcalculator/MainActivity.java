package com.example.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText amountEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountEditText = findViewById(R.id.amountEditText);
        resultTextView = findViewById(R.id.resultTextView);

        Button button15 = findViewById(R.id.button15);
        Button button18 = findViewById(R.id.button18);
        Button button20 = findViewById(R.id.button20);

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip(0.15);
            }
        });

        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip(0.18);
            }
        });

        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip(0.20);
            }
        });
    }

    private void calculateTip(double percentage) {
        String amountText = amountEditText.getText().toString();
        if (!amountText.isEmpty()) {
            double amount = Double.parseDouble(amountText);
            double tip = amount * percentage;
            double total = amount + tip;
            resultTextView.setText(String.format("Tip: $%.2f, Total Bill: $%.2f", tip, total));
        }
    }
}
