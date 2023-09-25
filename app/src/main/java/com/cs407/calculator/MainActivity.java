package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText first;
    EditText second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = findViewById(R.id.firstNumber);
        second = findViewById(R.id.secondNumber);
    }

    public void switchAct(String s) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("message", s);
        startActivity(intent);
    }

    public void add(View view) {
        Log.d("Calculator", "Add button clicked");
        int result = getFirstNumb() + getSecondNumb();
        switchAct(String.format("%d", result));
    }

    public void minus(View view) {
        int result = getFirstNumb() - getSecondNumb();
        switchAct(String.format("%d", result));
    }

    public void mult(View view) {
        int result = getFirstNumb() * getSecondNumb();
        switchAct(String.format("%d", result));
    }

    public void div(View view) {
        int secondNum = getSecondNumb();
        if (secondNum == 0) {
            Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
        } else {
            double result = (double) getFirstNumb() / secondNum;
            switchAct(String.format("%.2f", result));
        }
    }

    private int getFirstNumb() {
        int number = Integer.parseInt(first.getText().toString());
        return number;
    }

    private int getSecondNumb() {
        int number = Integer.parseInt(second.getText().toString());
        return number;
    }
}