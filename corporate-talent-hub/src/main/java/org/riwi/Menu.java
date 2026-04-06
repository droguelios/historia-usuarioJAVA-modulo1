package org.riwi;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;

public class Menu {

    /**
     * TASK 4 - Operador Ternario y Switch Moderno (Java 17+)
     * Determina la categoría basada en rangos salariales.
     */
    public static String obtenerCategoriaSalarial(double salario) {
        // Uso de ternarios anidados para definir un nivel lógico
        String nivel = salario > 3000000 ? "alto" : salario > 1500000 ? "medio" : "bajo";

        // Switch Expression (Java 17): más conciso y devuelve un valor directamente
        return switch (nivel) {
            case "alto"  -> "Categoría A - Senior";
            case "medio" -> "Categoría B - Mid";
            default      -> "Categoría C - Junior";
        };
    }

    public static void main(String[] args) {
        // TASK 2 - Inferencia de tipos (Java 11+): 'var' detecta que es un Scanner
        // .useLocale(Locale.US) asegura que el punto (.) sea el separador decimal
        var teclado = new Scanner(System.in).useLocale(Locale.US);

        /**
         * TASK 3 - Estructuras de Datos (Matrices / Arreglos Bidimensionales)
         * Representa una tabla donde: Filas = Empleados, Columnas = Notas trimestrales
         */
        double[][] calificaciones = {
                {4.5, 3.8, 4.2},
                {3.1, 4.0, 3.7},
                {4.8, 4.5, 4.9},
        };

        System.out.println("\n===== Reporte Trimestral (Análisis de Matrices) =====");
        for (int i = 0; i < calificaciones.length; i++) {
            double suma = 0;
            for (int j = 0; j < calificaciones[i].length; j++) {
                suma += calificaciones[i][j]; // Acumulación de valores en la matriz
            }
            double promedio = suma / calificaciones[i].length;

            /**
             * CASTING (Conversión de tipos):
             * Convertimos de double a int. Nota: Se pierde la parte decimal (truncado).
             */
            int puntaje = (int) promedio;
            System.out.println("Empleado " + (i + 1) + " | Promedio: " + promedio + " | Puntaje: " + puntaje);
        }

        int opcion = -1;

        // Bucle Do-While: Garantiza que el menú se muestre al menos una vez
        do {
            System.out.println("\n===== Sistema de Gestión Riwi =====");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Ver empleados");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            /**
             * MANEJO DE EXCEPCIONES:
             * Evita que el programa "explote" si el usuario ingresa letras en un campo numérico.
             */
            try {
                opcion = teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("¡Error! Debes ingresar un número entero.");
                teclado.next(); // Limpieza del buffer del Scanner
                opcion = -1;
                continue; // Salta al inicio del bucle
            }

            /**
             * TASK 1 - Switch con Flechas (Java 12/17+)
             * Elimina la necesidad del 'break' y evita el error de "fall-through" de Java 8.
             */
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

                    // Validación de rangos con operadores lógicos (AND)
                    if (edad >= 18 && edad <= 65) {
                        System.out.println("-> Edad dentro del rango legal.");
                    } else {
                        System.out.println("-> Alerta: Edad fuera de rango.");
                    }

                    // Operador Ternario simple para decidir el estado
                    String estado = promedio >= 3.5 ? "Promovido" : "No Promovido";

                    System.out.println("\n====== Ficha Resultante ======");
                    System.out.println("Nombre:    " + nombre);
                    System.out.println("Estado:    " + estado);
                    System.out.println("Categoría: " + obtenerCategoriaSalarial(salario));
                }
                case 2 -> System.out.println("Cargando lista de empleados desde la memoria...");
                case 0 -> System.out.println("Cerrando sesión. ¡Buen trabajo, JJ!");
                default -> System.out.println("Opción no reconocida en el sistema.");
            }

        } while (opcion != 0);

        teclado.close(); // Buena práctica: liberar el recurso del teclado
    }
}