package org.riwi.models;

public class Salary {
    int employeeId = 10;
    float salary = 2000.50f;

    public double calculateSalary(double baseSalary, double monthlyBonus){
        return (baseSalary + (monthlyBonus * 1.10)) - (baseSalary * 0.05);
    }

    public boolean hasExtraBonus(){
        return (employeeId % 2 == 0);
    }

    public boolean validateEligibility(int testScore, int age, int branchId, boolean isActive){
        return (testScore > 85 && age < 30 ) || (branchId == 1 && !isActive);
    }

    public void updateBonus(double increase){
        double bonus = salary;
        System.out.println("bonus before: " + bonus);
        bonus += increase;
        System.out.println("updated bonus: " + bonus);
    }
}