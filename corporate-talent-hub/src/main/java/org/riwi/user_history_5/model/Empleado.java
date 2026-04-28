package org.riwi.user_history_5.model;

public class Empleado {
    private int id;
    private String nombre;
    private double salario;
    private int edad;

    public Empleado() {}

    public Empleado(int id, String nombre, double salario, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Salario: $" + salario + " | Edad: " + edad;
    }
}
