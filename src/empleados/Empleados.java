package empleados;

record EmpresaRecord (String nombre, String nit , int aniofundacion){}

public class Empleados {

    long presupuesto= 900000000L;

    short codigopostal=12345;

    int id_empleado= 10500;

    double Precio = 29.00;

    float salario = 2000.50f;

    char inicial = 'a';

    boolean esactivo= true;

    byte Edad = 21;

    String nombrecompleto = "alejandro";

    public void motrarInfo(){

        String saludo = """
                ================================
                Bienvenido a record company
                ================================
                """;
        System.out.printf(saludo);
        EmpresaRecord fundado = new EmpresaRecord ("RIWI" , "900.123.456",2023);

        System.out.printf("Empresa: " +fundado.nombre()+" | NIT: "+fundado.nit());

        System.out.println(" empleado " +  nombrecompleto + "(ID:" +id_empleado + ") ");
        System.out.println(" salario con bono: " + (salario +Precio));

    }

}
