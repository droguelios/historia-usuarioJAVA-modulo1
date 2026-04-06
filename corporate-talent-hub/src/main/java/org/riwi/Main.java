package org.riwi;

import org.riwi.models.Employee;
import org.riwi.models.Salary;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Salary pme = new Salary();
        pme.calculateSalary(3000000, 50000);

        Employee emp = new Employee();
        emp.showInfo();

        Menu.main(new String[]{});

    }

}