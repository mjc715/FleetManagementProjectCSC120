public class Boat {
    private String name;
    private int value;
    private int expenses;

    public void Boat() {
        name = "";
        value = 0;
        expenses = 0;
    }
    public void Boat(String name, int value) {
        expenses = 0;
        this.name = name;
        this.value = value;
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
    public String toString() {
        return("");
    }
}
