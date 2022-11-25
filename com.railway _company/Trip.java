import java.util.*;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

class Trip{
    //collection to store avalible dates
    public static  SortedSet<String> Dates = new TreeSet<String>();
    private int number;
    //driver of the trip combositie 
    private Driver driver;
    private String date;
    private int maxNumOfPassanger;
    //collection for passangers in same trip
    private ArrayList<Passanger> Passangers = new ArrayList<Passanger>();

    public Trip(int number, Driver driver, String date, int maxNumOfPassanger) {
        this.number = number;
        this.driver = driver;
        this.date = date;
        this.maxNumOfPassanger = maxNumOfPassanger;
        Dates.add(date);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getMaxNumOfPassanger() {
        return maxNumOfPassanger;
    }
    public void setMaxNumOfPassanger(int maxNumOfPassanger) {
        this.maxNumOfPassanger = maxNumOfPassanger;
    }
    public int numOfPassangers(){
        return Passangers.size();
    }
    public boolean addPassanger (Passanger passanger){
        //check if trip is full or not
        if (Passangers.size() >= maxNumOfPassanger){
            System.out.println("This trip if full");
            return false;
        }
        for (Passanger pass : Passangers){
            //check if passanger is already in trip
            if (pass.equals(passanger) == true){
                System.out.println("Already Added");
                return false;
            }
        }
        Passangers.add(passanger);
        System.out.println("Added");
        return true;
    }
    public void removePassanger(Passanger passanger){
        for (Passanger pass : Passangers){
            //check if already in
            if (pass.equals(passanger) == true){
                Passangers.remove(pass);
                System.out.println("Removed");
                return;
            }
            System.out.println("Not found");
        }

    }
    @Override
    public String toString() {
        return "Trip [number=" + number + ", date=" + date + ", maxNumOfPassanger=" + maxNumOfPassanger + "]";
    }
}