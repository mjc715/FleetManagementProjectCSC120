import java.io.*;
import java.util.*;
//======================================================================================================================
public class FleetManagement {
    private static final Scanner keyboard = new Scanner(System.in);
//----------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        BoatHolder daFleet;
        Scanner fileScanner = null;

        boolean proceed = false;
        String inputLine, name;
        double expense;
        int boatPosition = -1;

        if (args.length > 0) {
            daFleet = new BoatHolder(inputData(args[0]));
        } else {
            daFleet = new BoatHolder(inputData("FleetData.db"));
        }
        System.out.println("Welcome to Castellucci Fleet Management");
        System.out.println("---------------------------------------");
        System.out.println();
        try {
            while (!proceed) {
                System.out.println("(P)rint, (A)dd, (R)emove, (E)xpense, or E(x)it");
                switch (keyboard.next().toUpperCase().charAt(0)) {
                    case 'P':
                        daFleet.displayFleet();
                        System.out.println();
                        break;
                    case 'A':
                        System.out.printf("%-50s:", "Please enter the new boat CSV data");
                        keyboard.nextLine();
                        inputLine = keyboard.nextLine();
                        daFleet.addBoat(inputLine);
                        break;
                    case 'R':
                        System.out.println("Which boat to remove?");
                        keyboard.nextLine();
                        name = keyboard.nextLine();
                        boatPosition = daFleet.findBoat(name.toUpperCase());
                        if (boatPosition == -1) {
                            System.out.println(name + " not found.");
                            break;
                        } else {
                            daFleet.removeBoat(boatPosition);
                            System.out.println("Boat removed successfully");
                            break;
                        }

                    case 'E':
                        System.out.println("Which boat do you want to spend on?");
                        keyboard.nextLine();
                        name = keyboard.nextLine();
                        boatPosition = daFleet.findBoat(name);
                        if (boatPosition == -1) {
                            System.out.println(name + " not found.");
                            break;
                        } else {
                            System.out.println("How much do you want to spend?");
                            expense = keyboard.nextDouble();
                            daFleet.addExpense(expense, boatPosition);
                        }
                        break;
                    case 'X':
                        System.out.println("Exiting Castellucci Fleet Management");
                        saveFleet(daFleet);
                        proceed = true;
                        break;
                    default:
                        System.out.println("Invalid menu option, try again.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

//----------------------------------------------------------------------------------------------------------------------
    private static ArrayList<Boat> inputData(String fileName) {

        Scanner fileScanner = null;
        String type, model, name, line;
        int length, year, typeInt;
        double price;
        ArrayList<Boat> boatList = new ArrayList<>();

        try {
            fileScanner = new Scanner(new FileInputStream(fileName));
            while (fileScanner.hasNextLine()) {
                line = fileScanner.nextLine();

                String[] attributes = line.split(",");
                Boat boat = new Boat(attributes);
                boatList.add(boat);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (fileScanner != null) {
                fileScanner.close();
            }
        }
        return(boatList);
    }
//----------------------------------------------------------------------------------------------------------------------
    private static void saveFleet(BoatHolder daFleet) {
        ObjectOutputStream toStream = null;
        try {
            toStream = new ObjectOutputStream(new FileOutputStream("FleetData.txt"));
            toStream.writeObject(daFleet);

        } catch (IOException e) {
            System.out.println("Error saving 1: " + e.getMessage());
        } finally {
            if (toStream != null) {
                try {
                    toStream.close();
                } catch (IOException e) {
                    System.out.println("Error saving 2: " + e.getMessage());
                }
            }
        }

    }

//----------------------------------------------------------------------------------------------------------------------
}
//======================================================================================================================