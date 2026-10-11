package com.namatnaghiyev.simplecalculator.ui;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.namatnaghiyev.simplecalculator.R;
import com.namatnaghiyev.simplecalculator.domain.Calculator;
import com.namatnaghiyev.simplecalculator.domain.Operation;

public class MainActivity extends AppCompatActivity {
    private EditText firstNumberInput;
    private EditText secondNumberInput;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumberInput = findViewById(R.id.firstNumberInput);
        secondNumberInput = findViewById(R.id.secondNumberInput);
        resultText = findViewById(R.id.resultText);

        findViewById(R.id.addButton).setOnClickListener(v -> showResult(Operation.ADD));
        findViewById(R.id.subtractButton).setOnClickListener(v -> showResult(Operation.SUBTRACT));
        findViewById(R.id.multiplyButton).setOnClickListener(v -> showResult(Operation.MULTIPLY));
        findViewById(R.id.divideButton).setOnClickListener(v -> showResult(Operation.DIVIDE));
        findViewById(R.id.clearButton).setOnClickListener(v -> clearInputs());
    }

    private void showResult(Operation operation) {
        try {
            String result = Calculator.calculate(
                    firstNumberInput.getText().toString(),
                    secondNumberInput.getText().toString(),
                    operation
            );
            resultText.setText(result);
        } catch (IllegalArgumentException exception) {
            resultText.setText(exception.getMessage());
        }
    }

    private void clearInputs() {
        firstNumberInput.setText("");
        secondNumberInput.setText("");
        resultText.setText(R.string.initial_result);
        firstNumberInput.requestFocus();
    }
}
