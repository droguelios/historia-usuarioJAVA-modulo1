package empleados;

record EmpresaRecord (String nombre, String nit , int aniofundacion){}

public class Empleados {

    //Variable long por yerminos de que el presupuesto de una empresa puede superar los decimales
    //y los enteros por eso se colo como long = presupuesto ya que como podemos ver superan los decimales
    long presupuesto = 900000000L;

    //shor un dato primitivo ya que estamos hablando de numeros de muy pocos digitos
    // obviamente un codigo postal es mas largo pero estamos hablando de un ejemplo de un dato short
    short codigopostal=12345;

    //ID es un dato entero claramente esto va escalando ya que un usuario puede tener
    // mas de un digito en su ID
    int idempleado= 10;

    //double aqui ya nos metemos con los decimales ya que llevan puntos o son datos que
    //matematicamente hablando se necesita saber cuanto seria unala suvida o la resta de un numero
    double Precio = 29.00;

    int idempleados= 10500;

    double precio = 29.00;

    //Aqui seria lo mismo con los decimales pero siendo mas exactos este seria el int o el double
    // de decimales mas pequeños ya qie podrian ser decimales mas grandes o pequeños
    float salario = 2000.50f;

    //Se uso char en caso de que alguien o en algun futuro quiera agregar de que pueda encontrar a un
    // usuario por la primera inicial de su letra dependiendo si quiero la que inicia o yermina por una letra
    char inicial = 'a';

    //boleanos codiciones de que si cierto usuario esta activo es verdadero pero si esta despedido por asi decirlo
    // o no aparece la condicioon seria falsa o visebersa el usaurio esta activo falso pero no aparece es verdadero
    boolean esactivo= true;

    //numeros enterios mas pequeños aqui tambien podria aplicar el int pero decidi usar el byte ya que
    //la edad no puede llegar a niveles tan altos como los 200 o 300 años
    byte Edad = 21;

    //STR(STRING) cadena de texto donde literalmente lo que estoy declarando es solo texto
    // si pongo numeros podria aver o no un error
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

        System.out.println(" empleado " +  nombrecompleto + "(ID:" +idempleado + ") ");

        System.out.println(" salario con bono: " + (salario +Precio));

        System.out.println(" salario con bono: " + (salario +precio));


    }

}
