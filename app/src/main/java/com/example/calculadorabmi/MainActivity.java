package com.example.calculadorabmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private TextView pesEditText;
    private TextView alcadaEditText;
    private Button calcularButton;
    private TextView bmiCalculatTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesEditText = (EditText) findViewById(R.id.pesEditText);
        alcadaEditText = (EditText) findViewById(R.id.alcadaEditText);
        bmiCalculatTextView = (EditText) findViewById(R.id.bmiCalculatTextView);
//        pesEditText = (EditText) findViewById(R.id.pesEditText);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            // Vista --> VistaModel
            public void onClick(View view){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                mainViewModel.calcularBMI(pesEditText.getText().toString(), alcadaEditText().getText().toString());
            }
        });

        final Observer<String> observerBMI = new Observer<String>() {
            @Override
            public void onChanged(String bmi) {
                bmiCalculatTextView.setText(bmi);
            }
        };

        mainViewModel.getBMI().observe(this, observerBMI);

    }
}