import java.io.*;
import java.util.*;
public class FleetManagement {
    public static void main(String[] args) {

        Scanner fileScanner = null;
        if (args.length > 0) {
            inputData(args[0]);
        }
    }
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
}
