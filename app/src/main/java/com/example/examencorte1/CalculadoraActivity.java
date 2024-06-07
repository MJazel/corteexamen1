package com.example.examencorte1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculadoraActivity extends AppCompatActivity {

    private TextView lblUsuario, lblResultado;
    private EditText etNum1, etNum2;
    private Button btnSuma, btnResta, btnMulti, btnDiv, btnLimpiar, btnRegresar;
    private Calculadora calculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        calculadora = new Calculadora();

        lblUsuario = findViewById(R.id.lblUsuario);
        lblResultado = findViewById(R.id.lblResultado);
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnSuma = findViewById(R.id.btnSuma);
        btnResta = findViewById(R.id.btnResta);
        btnMulti = findViewById(R.id.btnMulti);
        btnDiv = findViewById(R.id.btnDiv);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);

        String usuario = getIntent().getStringExtra("usuario");
        lblUsuario.setText("Usuario: " + usuario);

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacion("+");
            }
        });

        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacion("-");
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacion("*");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacion("/");
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarCampos();
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void realizarOperacion(String operacion) {
        String num1Str = etNum1.getText().toString();
        String num2Str = etNum2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            lblResultado.setText("Error: Campos vacíos");
            return;
        }

        float num1 = Float.parseFloat(num1Str);
        float num2 = Float.parseFloat(num2Str);

        calculadora.setNumeros(num1, num2);
        float resultado = 0;

        switch (operacion) {
            case "+":
                resultado = calculadora.suma();
                break;
            case "-":
                resultado = calculadora.resta();
                break;
            case "*":
                resultado = calculadora.multiplicacion();
                break;
            case "/":
                try {
                    resultado = calculadora.division();
                } catch (IllegalArgumentException e) {
                    lblResultado.setText("Error: " + e.getMessage());
                    return;
                }
                break;
        }

        lblResultado.setText("Resultado: " + resultado);
    }

    private void limpiarCampos() {
        etNum1.setText("");
        etNum2.setText("");
        lblResultado.setText("Resultado: ");
    }
}
