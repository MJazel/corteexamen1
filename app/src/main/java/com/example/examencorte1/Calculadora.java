package com.example.examencorte1;


public class Calculadora {

    // Método para sumar dos números
    public float suma(float num1, float num2) {
        return num1 + num2;
    }

    // Método para restar dos números
    public float resta(float num1, float num2) {
        return num1 - num2;
    }

    // Método para multiplicar dos números
    public float multiplicacion(float num1, float num2) {
        return num1 * num2;
    }

    // Método para dividir dos números
    public float division(float num1, float num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            // Manejar la división por cero
            throw new IllegalArgumentException("División por cero no permitida");
        }
    }
}

