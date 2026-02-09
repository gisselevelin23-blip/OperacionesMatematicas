package com.ucenm.operacionesmatematicas;

public class OperacionesMatematicas {
    // Atributos privados (POO)
    private double num1;
    private double num2;

    // Constructor que pide la tarea para transferir datos
    public OperacionesMatematicas(double n1, double n2) {
        this.num1 = n1;
        this.num2 = n2;
    }

    // Funciones Matemáticas requeridas
    public double sumar() { return num1 + num2; }
    public double restar() { return num1 - num2; }
    public double multiplicar() { return num1 * num2; }

    public String dividir() {
        if (num2 == 0) return "Error: División por cero";
        return String.valueOf(num1 / num2);
    }
}
