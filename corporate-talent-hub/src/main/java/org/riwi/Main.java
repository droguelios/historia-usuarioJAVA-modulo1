package org.riwi;

import org.riwi.models.Employee;
import org.riwi.models.Salary;
import org.riwi.user_history_4.DesempeñoReport;
import org.riwi.user_history_4.Employees;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Salary pme = new Salary();
        pme.calculateSalary(3000000, 50000);

        Employee emp = new Employee();
        emp.showInfo();

        Menu.main(new String[]{});

        Employees noc = new Employees("alejo", 3500.0);
        System.out.println("the name is " + noc.getName());


        ArrayList<DesempeñoReport> reports = new ArrayList<DesempeñoReport>();

        DesempeñoReport report1 = new DesempeñoReport(1, 3.5, "es medio tonto");
        DesempeñoReport report2 = new DesempeñoReport(2, 3.6,"gordo");

        reports.add(report1);
        reports.add(report2);

        System.out.println("==== Report about the employees ====");

        for (DesempeñoReport r : reports){
            System.out.println("ID" + r.idempleado() +
                    "promedio" + r.promedio() +
                    "feedback" + r.feedback());
        }


    }

}