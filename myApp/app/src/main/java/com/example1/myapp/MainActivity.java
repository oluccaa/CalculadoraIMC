package com.example1.myapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private EditText editPeso;
    private EditText editAltura;
    private TextView headerTitleId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        textResultado = findViewById(R.id.textResultado);
        headerTitleId = findViewById(R.id.headerTitleId);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        Button changeButtonColor = findViewById(R.id.changeButtonColor);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                calcularImc(a);
                editPeso.setText("");
                editAltura.setText("");
            }
        });
        changeButtonColor.setOnClickListener(new View.OnClickListener(){
            public void onClick(View b){buttonChangeColor(b);}
        });

    }
    public void buttonChangeColor(View b){
        Random random = new Random();
        int color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        headerTitleId.setTextColor(color);
    }

    @SuppressLint("SetTextI18n")
    public void calcularImc(View a){
        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());
        double resultado = (peso / (altura * altura));

        if(resultado < 19) {
            textResultado.setText("Abaixo do peso");
        } else if (resultado >= 19 && resultado < 25) {
            textResultado.setText("Peso normal");
        }else if (resultado >= 25 && resultado < 30) {
            textResultado.setText("Sobrepeso");
        }else if (resultado >= 30 && resultado < 40) {
            textResultado.setText("Obesidade Grau I");
        }else if (resultado >= 40) {
            textResultado.setText("Obesidade Grau II");
        }
    }
}