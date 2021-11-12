import java.util.*;
import java.io.*;
public class BoatHolder implements Serializable {

    private ArrayList<Boat> fleet;

    public BoatHolder() {
        fleet = new ArrayList<>();
    }
    public BoatHolder (ArrayList<Boat> boats) {
        this();
        fleet = boats;
    }
    public void displayFleet() {
        int i;

        System.out.println("Fleet report: ");
        for (i = 0; i < fleet.size(); i++) {
            fleet.get(i).printAll();
        }
    }
    public void addBoat(String inputLine) {

        String [] attributes = inputLine.split(",");
        Boat boat = new Boat(attributes);
        fleet.add(boat);
        System.out.println("Boat added successfully");

    }
    public int findBoat(String boatName) {
        int i;
        int boatPosition = -1;
        boolean found = false;

        while (!found) {
            for (i = 0; i < fleet.size(); i++) {
                if (boatName.toUpperCase().equals(fleet.get(i).getName())) {
                    found = true;
                    boatPosition = i;
                }
            }
            if (i == fleet.size() && !found) {
                found = true;
            }

        }
        return(boatPosition);
    }
    public void removeBoat(int boatNumber) {
        fleet.remove(boatNumber);
    }
    public void addExpense(double expense, int boatNumber) {
        if ((expense + fleet.get(boatNumber).getExpenses()) > fleet.get(boatNumber).getValue()) {
            System.out.println("Expense unauthorized, $" + (fleet.get(boatNumber).getValue() -
                    fleet.get(boatNumber).getExpenses() + " left to spend"));

        } else {
            fleet.get(boatNumber).addExpenses(expense);
            System.out.println("Expense authorized, $" + fleet.get(boatNumber).getExpenses() + " spent");
        }
    }
}
