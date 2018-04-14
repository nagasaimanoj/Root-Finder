package blogspot.nagasaimanoj.in.rootfinder;

import android.annotation.SuppressLint;
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

        final Button btnCalculate = findViewById(R.id.btnCalculate);
        final EditText etNumber = findViewById(R.id.etNumber);
        final EditText etRoot = findViewById(R.id.etRoot);
        final TextView tvHint = findViewById(R.id.tvHint);
        final TextView tvOutput = findViewById(R.id.tvOutput);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (etNumber.getText().toString().equals("") && etRoot.getText().toString().equals("")) {
                    tvOutput.setText("Enter Num & Root to continue");
                } else if (Double.valueOf(etNumber.getText().toString()) == 0d) {
                    tvOutput.setText(String.valueOf(0));
                } else if (Double.valueOf(etRoot.getText().toString()) == 0d) {
                    tvOutput.setText("Undefined");
                } else {
                    double num = Double.valueOf(etNumber.getText().toString());
                    double root = Double.valueOf(etRoot.getText().toString());
                    double result = rootFinder(num, root);
                    tvOutput.setText(String.valueOf(result));
                }
                tvHint.setText("press and hold calculate button to clear");
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

    double rootFinder(double num, double root) {

        Double start, end, mid_val, result;

        mid_val = 0d;

        if (root != 0) {
            start = 0d;
            end = num;

            mid_val = 0d;

            while (mid_val != (start + end) / 2) {
                mid_val = (start + end) / 2;
                result = Math.pow(mid_val, root);

                if (result < num) {
                    start = mid_val;
                } else if (result > num) {
                    end = mid_val;
                } else {
                    break;
                }
            }
        }
        return mid_val;
    }
}