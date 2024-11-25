package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editA;
    EditText editB;
    EditText editC;
    Button btn;
    TextView tv;
    double a,b,c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editA = findViewById(R.id.editTextA);
        editB = findViewById(R.id.editTextB);
        editC = findViewById(R.id.editTextC);
        btn = findViewById(R.id.button);
        tv = findViewById(R.id.textView);
        btn.setOnClickListener(view -> doSolve());
    }
    public void doSolve(){
        String str_a = editA.getText().toString();
        String str_b = editB.getText().toString();
        String str_c = editC.getText().toString();
        if (str_a.isEmpty()) {
            a = 0;
        } else  {a = Double.parseDouble(str_a);}
        if (str_b.isEmpty()) {
            b = 0;
        }else{b = Double.parseDouble(str_b);}
        if (str_c.isEmpty()) {
            c = 0;}
        else{c = Double.parseDouble(str_c);}

        double d = b * b - 4*a*c;
        if (a==0){
            double x = -c/b;
            tv.setText((String.format("x = "+x)));
        } else {
            if (d==0){
                double x = -b/2*a;
                tv.setText((String.format("x = "+x)));
            }else if (d>0){
                double x1 = (-b + Math.sqrt(d))/2*a;
                double x2 = (-b - Math.sqrt(d))/2*a;
                tv.setText((String.format("x1 = %.2f, x2 = %.2f", x1, x2)));
            } else {
                tv.setText(R.string.not_solve);
            }
        }
    }
}