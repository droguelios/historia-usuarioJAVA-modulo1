package Salario;

public class Salarios {
    int idempleado = 10;
    float salario = 2000.50f;

    public double calcularSalario(double salarioBase, double bonomensual){
        return (salarioBase + (bonomensual*1.10)) - (salarioBase*0.05);
    }

    public boolean tienebonoextra(){
        return (idempleado % 2 == 0);
    }

    public boolean validarElegibilidad(int puntajeTest, int edad, int idSede, boolean esActivo){
        return (puntajeTest > 85 && edad < 30 ) || (idSede == 1 && !esActivo);
    }
    public void actualizarBono (double incremento){
        double bono = salario;
        System.out.println("bono antes" + bono);
        bono += incremento;
        System.out.println("Bono actualizado" + bono);
    }
}
