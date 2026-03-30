import Salario.Salarios;
import empleados.Empleados;

public class Main {
    public static void main(String[] args) {
        Empleados emp = new Empleados();
        emp.motrarInfo();

        Salarios pme = new Salarios();
        pme.actualizarBono(15.000);


    }
}