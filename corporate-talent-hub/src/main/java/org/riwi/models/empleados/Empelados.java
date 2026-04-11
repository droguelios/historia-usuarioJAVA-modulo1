package org.riwi.models.empleados;

public class Empleados {

    private String id;
    private String nombre;
    private String empresa;
    private double salario;
    private int edad;

    public Empleado(String id, String nombre, String empresa,
                    double salario, int edad) {
        this.id       = id;
        this.nombre   = nombre;
        this.empresa  = empresa;
        this.salario  = salario;
        this.edad     = edad;
    }

    public String getId()       { return id; }
    public String getNombre()   { return nombre; }
    public String getEmpresa()  { return empresa; }
    public double getSalario()  { return salario; }
    public int getEdad()        { return edad; }

    @Override
    public String toString() {
        return "Empleado{id='" + id + "', nombre='" + nombre +
                "', salario=" + salario + "}";
    }
}