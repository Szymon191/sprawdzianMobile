package com.example.sprawdzian;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button button = findViewById(R.id.buttonOblicz);
        EditText textA = findViewById(R.id.editTextLiczbaA);
        EditText textB = findViewById(R.id.editTextNumberLiczbaB);
        EditText textC = findViewById(R.id.editTextNumberLiczbaC);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(String.valueOf(textA.getText().toString()));
                int b = Integer.parseInt(String.valueOf(textB.getText().toString()));
                int c = Integer.parseInt(String.valueOf(textC.getText().toString()));

                EditText editText = findViewById(R.id.editTextTextWynik);

                double delta = 0.0;
                delta = (double) (b*b) - 4 * a * c;


                if(delta < 0) {
                    Toast.makeText(getBaseContext(), "brak rozwiazan", Toast.LENGTH_SHORT).show();
                }
                else if(delta > 0){
                    double x1 = (-b + (Math.sqrt(delta))) / 2*a;
                    double x2 = (-b - (Math.sqrt(delta))) / 2*a;
                    editText.setText("x1: "+ x1 + "\n x2: " + x2);
                }
                else{
                    double wynik = -b / (2*a);
                    editText.setText("" + wynik);
                }

            }
        });
    }
}