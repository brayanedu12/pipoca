package com.example.calculadora_senai;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private double firstValue = Double.NaN;
    private double secondValue;
    private String currentOperation = "";
    private boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);

        // Mapeamento dos botões numéricos
        int[] numericButtonIds = {
                R.id.btn7, R.id.btn8, R.id.btn9
                // Adicionar os IDs dos demais botões numéricos (btn0 a btn6)
        };

        View.OnClickListener numberClickListener = v -> {
            Button button = (Button) v;
            if (isNewOperation) {
                tvDisplay.setText(button.getText().toString());
                isNewOperation = false;
            } else {
                tvDisplay.append(button.getText().toString());
            }
        };

        for (int id : numericButtonIds) {
            View b = findViewById(id);
            if (b != null) {
                b.setOnClickListener(numberClickListener);
            }
        }

        // Mapeamento das operações
        findViewById(R.id.btnDivide).setOnClickListener(v -> setOperation("/"));
        findViewById(R.id.btnMultiply).setOnClickListener(v -> setOperation("*"));

        // Botão Limpar (C)
        findViewById(R.id.btnClear).setOnClickListener(v -> {
            firstValue = Double.NaN;
            secondValue = Double.NaN;
            currentOperation = "";
            tvDisplay.setText("0");
            isNewOperation = true;
        });

        // Botão Apagar (Backspace)
        findViewById(R.id.btnBackspace).setOnClickListener(v -> {
            String text = tvDisplay.getText().toString();
            if (text.length() > 1) {
                tvDisplay.setText(text.substring(0, text.length() - 1));
            } else {
                tvDisplay.setText("0");
                isNewOperation = true;
            }
        });

        // Botão Igual (=)
        View btnEquals = findViewById(R.id.btnEquals);
        if (btnEquals != null) {
            btnEquals.setOnClickListener(v -> calculate());
        }
    }

    private void setOperation(String op) {
        if (!Double.isNaN(firstValue)) {
            calculate();
        } else {
            firstValue = Double.parseDouble(tvDisplay.getText().toString());
        }
        currentOperation = op;
        isNewOperation = true;
    }

    private void calculate() {
        if (!Double.isNaN(firstValue)) {
            secondValue = Double.parseDouble(tvDisplay.getText().toString());
            double result = 0;

            switch (currentOperation) {
                case "+":
                    result = firstValue + secondValue;
                    break;
                case "-":
                    result = firstValue - secondValue;
                    break;
                case "*":
                    result = firstValue * secondValue;
                    break;
                case "/":
                    if (secondValue != 0) {
                        result = firstValue / secondValue;
                    } else {
                        tvDisplay.setText("Erro");
                        firstValue = Double.NaN;
                        return;
                    }
                    break;
            }

            tvDisplay.setText(String.valueOf(result));
            firstValue = result;
            isNewOperation = true;
        }
    }
}