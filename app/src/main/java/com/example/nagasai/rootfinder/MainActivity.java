package com.example.nagasai.rootfinder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNumber = (EditText) findViewById(R.id.etNumber);
        EditText etRoot = (EditText) findViewById(R.id.etRoot);
        TextView tvOutput = (TextView) findViewById(R.id.tvOutput);
        TextView tvHint = (TextView) findViewById(R.id.tvHint);
        Button btnCalculate = (Button) findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etNumber.getText().toString().equals("") && etRoot.getText().toString().equals("")) {
                    tvOutput.setText(R.string.enter_numbers);
                } else if (etNumber.getText().toString().equals(0)) {
                    tvOutput.setText(String.value(0));
                } else if (etRoot.getText().toString().equals(0)) {
                    tvOutput.setText("Undefined");
                } else {
                    double num = Double.parseDouble(etNumber.getText().toString());
                    double root = Double.parseDouble(etRoot.getText().toString());
                    double result = rootFinder(num, root);
                    tvOutput.setText(String.valueOf(result);
                }
                tvHint.setText(R.string.clear_values);
            }
        });

        btnCalculate.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                etNumber.setText("");
                etRoot.setText("");
                tvOutput.setText("");
                tvHint.setText("");
                return true;
            }
        });
    }

    double rootFinder(double number, double root) {
        double mid_val = 0, result = 0, start = 0, end = number;
        while(mid_val != (start + end) / 2){
            mid_val = (start + end) / 2;
            result = Math.pow(mid_val, root);
            if(result > number)
                end = mid_val;
            else if(result < number)
                start = mid_val;
            else
                break;
        }
        return mid_val;
    }
}
