package org.riwi.talent.history.user5.modelo;

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
        return String.format("ID: %d | Nombre: %s | Salario: %.2f | Edad: %d", id, nombre, salario, edad);
    }
}
