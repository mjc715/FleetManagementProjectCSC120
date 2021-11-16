import java.io.Serializable;

//======================================================================================================================
 public class Boat implements Serializable {

    private String name, model, boatTypeString;
    private double value, expenses;
    private int year, boatTypeInt, length;


     private static enum boatType {POWER, SAILING};
    boatType boatTypes [] = boatType.values();
//----------------------------------------------------------------------------------------------------------------------
    public Boat() {
        name = "";
        value = 0;
        expenses = 0;
    }
//----------------------------------------------------------------------------------------------------------------------
    public Boat(int boatTypeInt, String name, int year, String model, int length, double value) {
        this();
        this.name = name;
        this.value = value;
        this.boatTypeInt = boatTypeInt;
        this.length = length;
        this.model = model;
        this.year = year;
    }
//----------------------------------------------------------------------------------------------------------------------
    public Boat(String [] boatData) {
        this();
        boatTypeString = boatData[0];
        name = boatData[1];
        year = Integer.parseInt(boatData[2]);
        model = boatData[3];
        length = Integer.parseInt(boatData[4]);
        value = Double.parseDouble(boatData[5]);

    }
 //---------------------------------------------------------------------------------------------------------------------
    public void printAll() {

        System.out.printf("    %8s %-20s %-5d%-10s%2d' Paid: $%9.2f Expenses: $ %9.2f\n", boatTypeString, name, year,
                model, length, value, expenses);

        }
//----------------------------------------------------------------------------------------------------------------------
    public String getName() {
        return(name.toUpperCase());
    }
//----------------------------------------------------------------------------------------------------------------------
    public double getExpenses() {
        return(expenses);
    }
//----------------------------------------------------------------------------------------------------------------------
    public double getValue() {
        return(value);
    }
//----------------------------------------------------------------------------------------------------------------------
    public void addExpenses(double expense) {
        expenses += expense;
    }
//----------------------------------------------------------------------------------------------------------------------
}
//======================================================================================================================


