import java.util.*;
import java.io.*;
public class BoatHolder implements Serializable {
    private ArrayList<Boat> fleet;

    public BoatHolder(ArrayList<Boat> boatList) {
        fleet = boatList;
    }

}
