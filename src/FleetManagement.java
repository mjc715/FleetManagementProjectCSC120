import java.io.*;
import java.util.*;
//======================================================================================================================
public class FleetManagement {
    private static Scanner keyboard = new Scanner(System.in);
//----------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        ArrayList<Boat> boatList = new ArrayList<>();
        Scanner fileScanner = null;

        boolean proceed = false;

        if (args.length > 0) {
           boatList = inputData(args[0]);
        }
        System.out.println("Welcome to Castellucci Fleet Management");
        System.out.println("---------------------------------------");
        System.out.println();
        try {
            while (!proceed) {
                System.out.println("(P)rint, (A)dd, (R)emove, (E)xpense, or E(x)it");
                switch (keyboard.next().charAt(0)) {
                    case 'P':
                        printFleet(boatList);
                        System.out.println();
                        break;
                    case 'A':
                        boatList = addBoat(boatList);
                        break;
                    case 'R':
                        //removeBoat();
                        break;

                    case 'E':
                        //boatExpense();
                        break;
                    case 'X':
                        //exitAndSave();
                        proceed = true;
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
    private static void printFleet(ArrayList<Boat> boatList) {

        int i;
        System.out.println("Fleet report:");
        for (i = 0; i < boatList.size(); ++i) {
            boatList.get(i).printAll();
        }
    }

//----------------------------------------------------------------------------------------------------------------------
    private static ArrayList<Boat> addBoat(ArrayList<Boat> boatList) {
        String inputLine;
        System.out.printf("%-50s:", "Please enter the new boat CSV data");
        inputLine = keyboard.nextLine();
        inputLine = keyboard.nextLine();
        String [] attributes = inputLine.split(",");
        Boat boat = new Boat(attributes);
        boatList.add(boat);
        return(boatList);
    }
}
//======================================================================================================================