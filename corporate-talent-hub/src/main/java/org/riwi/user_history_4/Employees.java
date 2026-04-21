package org.riwi.user_history_4;

public class Employees {
    private String name;
    private double salaries;

    public Employees(String name, double salaries){
        this.name = name;
        this.salaries = salaries;
        System.out.println("object created with success");
    }

    public String getName(){
        return this.name;
    }

    public double getSalaries(){
        return this.salaries;
    }
}
