package com.example.example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    Double firstValues, secondValues, result_operation;
    String operation;

    Double saveValues;
    Double saveValues2;
    String saveOperation;
    Double saveResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result_field);
        if (savedInstanceState !=null){
            saveValues =  savedInstanceState.getDouble("number1 ");
            saveValues2 =  savedInstanceState.getDouble("number2 ");
            saveOperation =  savedInstanceState.getString("operation ");
            firstValues = saveValues;
            secondValues = saveValues2;
            operation = saveOperation;
        }
        Log.d("ololo", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ololo", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ololo", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ololo", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ololo", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ololo", "onDestroy");
    }


    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.clear:
                result.setText("");
                break;
            case R.id.seven:
                result.append("7");
                break;
            case R.id.eight:
                result.append("8");
                break;
            case R.id.nine:
                result.append("9");
                break;
            case R.id.four:
                result.append("4");
                break;
            case R.id.five:
                result.append("5");
                break;
            case R.id.six:
                result.append("6");
                break;
            case R.id.one:
                result.append("1");
                break;
            case R.id.two:
                result.append("2");
                break;
            case R.id.three:
                result.append("3");
                break;
            case R.id.point:
                if (result != result) {
                    result.append(",");
                }
                break;
            case R.id.nul:
                result.append("0");
                break;
        }
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.plus:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "+");
                operation = "+";
                break;
            case R.id.minus:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "-");
                operation = "-";
                break;
            case R.id.multiply:
                operation = "*";
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "*");
                break;
            case R.id.divide:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "/");
                operation = "/";
                break;
            case R.id.equally:
                if (operation != null) {
                    String two = result.getText().toString().replace(firstValues + operation, "");
                    secondValues = Double.valueOf(two);
                    switch (operation) {
                        case "+":
                            plusOperation();
                            break;
                        case "-":
                            minusOperation();
                            break;
                        case "*":
                            multiplyOperation();
                            break;
                        case "/":

                            if (firstValues > 0) {
                                try {
                                    divideOperation();
                                } catch (ArithmeticException AE) {
                                    result.setText("");
                                }
                            }
                            break;
                    }
                }

        }
    }

    public void plusOperation() {
        result_operation = firstValues + secondValues;
        result.setText(result_operation.toString());
    }

    public void minusOperation() {
        result_operation = firstValues - secondValues;
        result.setText(result_operation.toString());
    }

    public void multiplyOperation() {
        result_operation = firstValues * secondValues;
        result.setText(result_operation.toString());
    }

    public void divideOperation() {
        result_operation = firstValues / secondValues;
        result.setText(result_operation.toString());
    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        firstValues=saveValues;
        secondValues=saveValues2;
        operation=saveOperation;

        if (firstValues != null){
            outState.putDouble("number1", firstValues);
        }
        if (secondValues != null){
            outState.putDouble("number2", secondValues);
        }
        if (operation != null){
            outState.putString("operator", operation);
        }
        Log.d("ololo", "onSaveInstanceState");
    }

}