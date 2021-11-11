
 public class Boat {

    private String name, model;
    private double value;
    private int expenses, year, boatTypeInt, length;


     private static enum boatType {POWER, SAILING};
    boatType boatTypes [] = boatType.values();

    public Boat() {
        name = "";
        value = 0;
        expenses = 0;
    }
    public Boat(int boatTypeInt, String name, int year, String model, int length, double value) {
        this();
        this.name = name;
        this.value = value;
        this.boatTypeInt = boatTypeInt;
        this.length = length;
        this.model = model;
        this.year = year;
    }
    public Boat(String [] boatData) {
        this();
        if (boatData[0].equals("POWER")) {
            boatTypeInt = 0;
        } else {
            boatTypeInt = 1;
        }
        name = boatData[1];
        year = Integer.parseInt(boatData[2]);
        model = boatData[3];
        length = Integer.parseInt(boatData[4]);
        value = Double.parseDouble(boatData[5]);

    }
    public double getValue() {
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
