package com.example.examencorte1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText etUsuario, etContrasena;
    private Button btnIngresar, btnSalir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        etUsuario = findViewById(R.id.etUsuario);
        etContrasena = findViewById(R.id.etContrasena);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnSalir = findViewById(R.id.btnSalir);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString();
                String contrasena = etContrasena.getText().toString();

                if (validarCampos(usuario, contrasena) && validarCredenciales(usuario, contrasena)) {
                    Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
                    intent.putExtra("usuario", usuario);
                    startActivity(intent);
                }
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private boolean validarCampos(String usuario, String contrasena) {
        if (usuario.isEmpty()) {
            mostrarError("El campo de usuario está vacío.");
            return false;
        }
        if (contrasena.isEmpty()) {
            mostrarError("El campo de contraseña está vacío.");
            return false;
        }
        if (contrasena.length() < 3) {
            mostrarError("La contraseña debe tener al menos 3 caracteres.");
            return false;
        }
        return true;
    }

    private boolean validarCredenciales(String usuario, String contrasena) {
        if ("lobatos".equals(usuario) && "789".equals(contrasena)) {
            return true;
        } else {
            mostrarError("Usuario o contraseña incorrectos.");
            return false;
        }
    }

    private void mostrarError(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}