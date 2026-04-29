package org.riwi.talent.history.user5.vista;

import org.riwi.talent.history.user5.controlador.EmpleadoController;
import org.riwi.talent.history.user5.modelo.Empleado;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {

    private final EmpleadoController controller;
    private final Scanner scanner;

    public ConsoleView() {
        this.controller = new EmpleadoController();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion = -1;

        do {
            System.out.println("\n--- Sistema de Gestión de Empleados ---");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Listar todos los empleados");
            System.out.println("3. Actualizar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor ingresa un número válido.");
                scanner.nextLine(); // Limpiar buffer en caso de error
                continue;
            }

            switch (opcion) {
                case 1 -> mostrarFormularioRegistro();
                case 2 -> mostrarListaEmpleados();
                case 3 -> mostrarFormularioActualizacion();
                case 4 -> mostrarFormularioEliminacion();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void mostrarFormularioRegistro() {
        try {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Salario: ");
            double salario = scanner.nextDouble();

            System.out.print("Edad: ");
            int edad = scanner.nextInt();

            controller.registrarEmpleado(nombre, salario, edad);
            System.out.println("Registro completado con éxito.");

        } catch (InputMismatchException e) {
            System.out.println("Datos inválidos, registro cancelado.");
            scanner.nextLine();
        }
    }

    private void mostrarListaEmpleados() {
        List<Empleado> empleados = controller.obtenerTodosLosEmpleados();
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("\n--- Lista de Empleados ---");
            for (Empleado emp : empleados) {
                System.out.println(emp.toString());
            }
        }
    }

    private void mostrarFormularioActualizacion() {
        try {
            System.out.print("ID del empleado a actualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Nuevo salario: ");
            double salario = scanner.nextDouble();

            System.out.print("Nueva edad: ");
            int edad = scanner.nextInt();

            controller.actualizarEmpleado(id, nombre, salario, edad);
            System.out.println("Actualización procesada.");

        } catch (InputMismatchException e) {
            System.out.println("Datos inválidos, actualización cancelada.");
            scanner.nextLine();
        }
    }

    private void mostrarFormularioEliminacion() {
        try {
            System.out.print("ID del empleado a eliminar: ");
            int id = scanner.nextInt();

            controller.eliminarEmpleado(id);
            System.out.println("Eliminación procesada.");

        } catch (InputMismatchException e) {
            System.out.println("ID inválido, operación cancelada.");
            scanner.nextLine();
        }
    }
}
