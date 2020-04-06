package com.example.example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;
    Double firstValues, secondValues, result_op;
    String operation;
    Double number1;
    Double number2;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result_field);
        if (savedInstanceState != null) {
            number1 = savedInstanceState.getDouble("number1 ");
            number2 = savedInstanceState.getDouble("number2 ");
            operator = savedInstanceState.getString("operator ");
            firstValues = number1;
            secondValues = number2;
            operation = operator;
        }

        Log.d("ololo", "onCreate");
        Log.d("ololo", "Saved Double:"+ number1);
    }


    public void onNumberClick(View view) {
        switch (view.getId()) {
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
            case R.id.nul:
                result.append("0");
                break;

            case R.id.clear:
                result.setText(null);
                break;
            case R.id.point:
                if (firstValues == null) {
                    result.setText("0.");
                } else {
                    firstValues = Double.valueOf(result.getText().toString());
                    result.append(".");
                    operation = ".";
                    break;
                }

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
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "*");
                operation = "*";
                break;
            case R.id.divide:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "/");
                operation = "/";
                break;
            case R.id.equally:
                if (operation != null) {
                    String two = result.getText().toString().replace(firstValues.toString() + operation, " ");
                    secondValues = Double.valueOf(two);
                    switch (operation) {
                        case "+":
                            plus();
                            break;

                        case "-":
                            minus();
                            break;

                        case "*":
                            multiply();
                            break;

                        case "/":
                            division();
                            break;
                    }
                }
                break;

        }
    }

    public void plus() {
        result_op = firstValues + secondValues;
        result.setText(firstValues + "+" + secondValues + "=" + result_op);
    }

    public void minus() {
        result_op = firstValues - secondValues;
        result.setText(firstValues + "-" + secondValues + "=" + result_op);
    }

    public void multiply() {
        result_op = firstValues * secondValues;
        result.setText(firstValues + "*" + secondValues + "=" + result_op);
    }

    public void division() {
        result_op = firstValues / secondValues;
        result.setText(firstValues + "/" + secondValues + "=" + result_op);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ololo", "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ololo", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ololo", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ololo", "onRestart");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ololo","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ololo","onPause");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("ololo", "onSaveInstanceState");
        outState.putDouble("saved_double",firstValues);
        outState.putDouble("saved_double",secondValues);
        outState.putString("saved_double",operator);
    }
}

