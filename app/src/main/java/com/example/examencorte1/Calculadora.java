package com.example.examencorte1;

public class Calculadora {

    private float num1;
    private float num2;

    public Calculadora() {
    }

    public void setNumeros(float num1, float num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public float suma() {
        return num1 + num2;
    }

    public float resta() {
        return num1 - num2;
    }

    public float multiplicacion() {
        return num1 * num2;
    }

    public float division() {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new IllegalArgumentException("División por cero no permitida");
        }
    }
}
