package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnCalculator;
    private EditText number1, number2;
    private TextView result;
    private Spinner spOperator;
    private String operator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btnCalculator.setOnClickListener(this);
        spOperator.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                operator = spOperator.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == btnCalculator){
            Log.d("AppLog","Here");
           double num1, num2;
           num1 = Double.parseDouble(number1.getText().toString());
           num2 = Double.parseDouble(number2.getText().toString());
           result.setText(calculate(num1, num2, operator));
        }
    }

    private void initView(){
        btnCalculator = findViewById(R.id.cal);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        spOperator = findViewById(R.id.operation);
        result = findViewById(R.id.result);
    }

    private String calculate(double n1, double n2, String op){
        String result="";
        Log.d(n1+"", n1+" xin chao");

        switch (op){
            case "+":
                result="Sum:"+(n1+n2);
                return result;
            case "-":
                result="Substract:"+(n1-n2);
                break;
            case "x":
                result="Multiply:"+(n1*n2);
                break;
            case ":":
                if(n2==0){
                    result="not divide by zero";
                }else {
                    result = "Divide:" + (n1 / n2);
                }
                break;
        }
        Log.d("AppLog",result+"");
        return result;
    }
}