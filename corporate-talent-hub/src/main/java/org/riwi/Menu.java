package org.riwi;

import java.util.*;

public class Menu {

    /**
     * TASK 4 - Ternary Operator and Modern Switch (Java 17+)
     * Determines the category based on salary ranges.
     */
    public static String getSalaryCategory(double salary) {
        // Nested ternary operators to define logical levels
        String level = salary > 3000000 ? "high" : salary > 1500000 ? "medium" : "low";

        // Switch Expression (Java 17): concise and returns a value directly
        return switch (level) {
            case "high"   -> "Category A - Senior";
            case "medium" -> "Category B - Mid";
            default       -> "Category C - Junior";
        };
    }

    public static void main(String[] args) {
        // TASK 2 - Type Inference (Java 11+): 'var' detects it's a Scanner
        // .useLocale(Locale.US) ensures the dot (.) is used as the decimal separator
        var keyboard = new Scanner(System.in).useLocale(Locale.US);

        /**
         * TASK 3 - Data Structures (Matrices / 2D Arrays)
         * Represents a table where: Rows = Employees, Columns = Quarterly grades
         */
        double[][] grades = {
                {4.5, 3.8, 4.2},
                {3.1, 4.0, 3.7},
                {4.8, 4.5, 4.9},
        };

        System.out.println("\n===== Quarterly Report (Matrix Analysis) =====");
        for (int i = 0; i < grades.length; i++) {
            double sum = 0;
            for (int j = 0; j < grades[i].length; j++) {
                sum += grades[i][j]; // Accumulating values in the matrix
            }
            double average = sum / grades[i].length;

            /**
             * CASTING (Type conversion):
             * Converting from double to int. Note: Decimal part is lost (truncated).
             */
            int score = (int) average;
            System.out.println("Employee " + (i + 1) + " | Average: " + average + " | Score: " + score);
        }

        int option = -1;

        // Do-While Loop: Guarantees the menu is displayed at least once
        do {
            System.out.println("\n===== Riwi Management System =====");
            System.out.println("1. Add employee");
            System.out.println("2. View employees");
            System.out.println("0. Exit");
            System.out.print("Option: ");

            /**
             * EXCEPTION HANDLING:
             * Prevents the program from crashing if the user enters letters in a numeric field.
             */
            try {
                option = keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("error: You must enter an integer number.");
                keyboard.next(); // Clear Scanner buffer
                option = -1;
                continue; // Jump to the beginning of the loop
            }

            /**
             * TASK 1 - Switch with Arrows (Java 12/17+)
             * Removes the need for 'break' and prevents "fall-through" errors.
             */
            switch (option) {
                case 1 -> {
                    System.out.print("Name: ");
                    var name = keyboard.next();

                    System.out.print("Age: ");
                    var age = keyboard.nextInt();

                    System.out.print("Average (0.0 - 5.0): ");
                    var average = keyboard.nextDouble();

                    System.out.print("Salary: ");
                    var salary = keyboard.nextDouble();

                    // Range validation with logical operators (AND)
                    if (age >= 18 && age <= 65) {
                        System.out.println("-> Age within legal range.");
                    } else {
                        System.out.println("-> Alert: Age out of range.");
                    }

                    // Simple Ternary Operator to decide status
                    String status = average >= 3.5 ? "Promoted" : "Not Promoted";

                    System.out.println("\n====== Resulting Profile ======");
                    System.out.println("Name:     " + name);
                    System.out.println("Status:   " + status);
                    System.out.println("Category: " + getSalaryCategory(salary));
                }
                case 2 -> System.out.println("Loading employee list from memory...");
                case 0 -> System.out.println("Closing session. Great job, Alejo!");
                default -> System.out.println("Option not recognized by the system.");
            }

        } while (option != 0);

        keyboard.close(); // Good practice: release keyboard resource
    }
}