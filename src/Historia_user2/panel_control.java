package Historia_user2;

import java.util.InputMismatchException;
import java.util.Scanner;
public class panel_control {

    // TASK 1 - Switch Expression moderna Java 17/21
    // Con -> no hay fall-through posible, no necesita break
    static String obtenerCategoriaSalarial(double salario) {
        String nivel = salario > 3000000 ? "alto" : salario > 1500000 ? "medio" : "bajo";
        return switch (nivel) {
            case "alto"  -> "Categoría A - Senior";
            case "medio" -> "Categoría B - Mid";
            default      -> "Categoría C - Junior";
        };
    }

    public static void main(String[] args) {

        // TASK 2 - Java 8: Scanner teclado = new Scanner(System.in);
        //          Java 11+: var infiere el tipo automáticamente
        var teclado = new Scanner(System.in);

        // TASK 1 - Switch LEGACY Java 8 (referencia comparativa)
        // El fall-through ocurre cuando se olvida el break:
        // case 1:
        //     System.out.println("Agregar");
        //     // sin break → cae al case 2 sin querer
        // case 2:
        //     System.out.println("Ver"); // se ejecuta sin quererlo

        // TASK 3 - Matriz: filas = empleados, columnas = trimestres
        double[][] calificaciones = {
                {4.5, 3.8, 4.2},
                {3.1, 4.0, 3.7},
                {4.8, 4.5, 4.9},
        };

        System.out.println("\n===== Reporte Trimestral =====");
        for (int i = 0; i < calificaciones.length; i++) {
            double suma = 0;
            for (int j = 0; j < calificaciones[i].length; j++) {
                suma += calificaciones[i][j];
            }
            double promedio = suma / calificaciones[i].length;

            // Casting double → int: 4.83 se convierte en 4, NO redondea
            int puntaje = (int) promedio;
            System.out.println("Empleado " + (i + 1) + " | Promedio: " + promedio + " | Puntaje: " + puntaje);
        }

        int opcion = -1;

        do {
            System.out.println("\n===== Sistema de Empleados =====");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Ver empleados");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            try {
                opcion = teclado.nextInt();
            } catch (InputMismatchException e) {
                // Java 8: mensaje genérico sin contexto
                // Java 17/21: indica qué valor causó el error y dónde
                System.out.println(" Error: Ingresa un número válido.");
                teclado.next();
                opcion = -1;
                continue;
            }

            // TASK 1 - Switch moderno Java 17/21
            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    var nombre = teclado.next();

                    System.out.print("Edad: ");
                    var edad = teclado.nextInt();

                    System.out.print("Promedio (0.0 - 5.0): ");
                    var promedio = teclado.nextDouble();

                    System.out.print("Salario: ");
                    var salario = teclado.nextDouble();

                    // TASK 2 - if/else validando rangos
                    if (edad >= 18 && edad <= 65) {
                        System.out.println("Edad válida");
                    } else {
                        System.out.println("Edad fuera de rango");
                    }

                    if (promedio >= 0.0 && promedio <= 5.0) {
                        System.out.println("Promedio válido");
                    } else {
                        System.out.println("Promedio fuera de rango");
                    }

                    // TASK 4 - Operador ternario para promoción
                    String estado = promedio >= 3.5 ? "promovido" : "no promovido";

                    System.out.println("\n====== Ficha del Empleado ======");
                    System.out.println("Nombre:    " + nombre);
                    System.out.println("Edad:      " + edad);
                    System.out.println("Promedio:  " + promedio);
                    System.out.println("Estado:    " + estado);
                    System.out.println("Salario:   $" + salario);
                    System.out.println("Categoría: " + obtenerCategoriaSalarial(salario));
                }
                case 2 -> System.out.println("Mostrando empleados...");
                case 0 -> System.out.println("Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        teclado.close();
    }
}