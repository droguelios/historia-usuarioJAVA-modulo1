package org.riwi.models;

public class Employee {

    // Company budget (long is used for large whole numbers)
    long budget = 900000000L;

    // Employee ZIP code (short is enough for small numeric values)
    short zipCode = 12345;

    // Unique employee identifier
    int employeeId = 10;

    // Product or bonus value (decimal number)
    double price = 29.00;

    // Employee salary (float for decimal values with less precision than double)
    float salary = 2000.50f;

    // First initial of the employee's name
    char initial = 'A';

    // Indicates whether the employee is currently active
    boolean isActive = true;

    // Employee age (byte is sufficient for small numbers)
    byte age = 21;

    // Full name of the employee
    String fullName = "Alejandro";

    public void showInfo() {

        // Welcome message using text block (Java 15+)
        String greeting = """
                ================================
                Welcome to Record Company
                ================================
                """;

        System.out.println(greeting);

        // Creating a Company record instance
        Company company = new Company("RIWI", "900.123.456", 2023);

        // Display company information
        System.out.println("Company: " + company.name() + " | NIT: " + company.nit());

        // Display employee basic information
        System.out.println("\nEmployee: " + fullName + " (ID: " + employeeId + ")");

        // Display calculated salary with bonus
        System.out.println("Salary with bonus: " + (salary + price));
    }
}