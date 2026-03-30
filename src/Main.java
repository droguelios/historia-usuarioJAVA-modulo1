import Salario.Salarios;
import empleados.Empleados;

public class Main {
    public static void main(String[] args) {
        Empleados emp = new Empleados();
        emp.motrarInfo();

        Salarios pme = new Salarios();
        pme.actualizarBono(15000);

        String nombre = null;
        try{nombre.toUpperCase();


        }catch (NullPointerException e){
            System.out.println("Error: " + e.getMessage());
        }

        Empleados e1= new Empleados();
        Empleados e2 = new Empleados();
        System.out.println("e1 == e2: "+(e1 == e2));

        Empleados e3 = e1;

        System.out.println("e1 == e3" + (e1 == e3));

    }
}