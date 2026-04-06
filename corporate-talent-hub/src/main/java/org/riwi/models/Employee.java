package org.riwi.models;

public class Employee {

    //Long variable because a company's budget can exceed decimals
    //and integers, that's why it was set as long = budget since as we can see they exceed decimals
    long budget = 900000000L;

    //short is a primitive data because we are talking about numbers with very few digits
    //obviously a zip code is longer but we are talking about an example of a short data
    short zipcode = 12345;

    //ID is an integer data clearly this scales up since a user can have
    //more than one digit in their ID
    int employeeId = 10;

    //double here we get into decimals since they have points or are data that
    //mathematically speaking we need to know how much an increase or decrease of a number would be
    double Price = 29.00;

    int employeeIds = 10500;

    double price = 29.00;

    //Here it would be the same with decimals but being more exact this would be the int or the double
    //of smaller decimals since they could be larger or smaller decimals
    float salary = 2000.50f;

    //Char was used in case someone or in some future wants to add that they can find a
    //user by the first initial of their letter depending on if I want the one that starts or ends with a letter
    char initial = 'a';

    //booleans conditions that if a certain user is active it is true but if they are fired so to speak
    //or don't appear the condition would be false or vice versa the user is active false but doesn't appear is true
    boolean isactive = true;

    //smaller integer numbers here the int could also apply but I decided to use byte since
    //age cannot reach levels as high as 200 or 300 years
    byte Age = 21;

    //STR(STRING) text string where literally what I am declaring is only text
    //if I put numbers there could or could not be an error
    String fullname = "alejandro";

    public void showInfo(){

        String greeting = """
                ================================
                Welcome to record company
                ================================
                """;
        System.out.printf(greeting);
        Company founded = new Company("RIWI" , "900.123.456", 2023);

        System.out.printf("Company: " + founded.nombre() + " | NIT: " + founded.nit());

        System.out.println(" employee " +  fullname + "(ID:" + employeeId + ") ");

        System.out.println(" salary with bonus: " + (salary + Price));

        System.out.println(" salary with bonus: " + (salary + price));

    }

}