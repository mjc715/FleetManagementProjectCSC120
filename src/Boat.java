
 public class Boat {

    private String name;
    private int value;
    private int expenses;
    private int boatTypeInt;


     private static enum boatType {POWER, SAILING};
    boatType boatTypes [] = boatType.values();

    public Boat() {
        name = "";
        value = 0;
        expenses = 0;
    }
    public Boat(String name, int value, int boatTypeInt) {
        this();
        this.name = name;
        this.value = value;
        this.boatTypeInt = boatTypeInt;
    }
    public int getValue() {
        return(value);
    }
    public String getName() {
        return(name);
    }
    public int getExpenses() {
        return(expenses);
    }
    public String getBoatType() {
        return(boatTypes[boatTypeInt].toString());
    }
    public String toString() {
        return("");
    }
}
