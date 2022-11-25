import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    //collection to store all trips data
    public static ArrayList<Trip> Trips = new ArrayList<Trip>();

    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        int ch;
        do {
            System.out.print("""
            1) Add new trip
            2) Addinga passengerto a specific trip
            3) Removing a passenger from a specific trip
            4) Retrieving the average number of passengers per trip of a specified date
            5) Displaying all available trips
            6) Saving all the data into a text file
            7) Exit
            Enter Number of operator you need : 
            """);
            ch = in.nextInt();
            switch (ch){
                case 1:
                    offerTrip();
                    break;
                case 2:
                    addToTrip();
                    break;
                case 3:
                    removeToTrip();
                    break;
                case 4:
                    System.out.println(avgPerDate());
                    break;
                case 5:
                    display();
                    break;
                case 6:

                    break;
                case 7:
                    System.out.println("Bye :)");
                    break;
                default:
                    System.out.println("Wrong number try again ");
            }
        }while (ch != 7);
    }
    /*
     *  offertrip - add new trip
     */
    public static void offerTrip(){
        int number;
        String date;
        int maxNumOfPassanger;
        String name;
        int age;
        int id;
        System.out.println("Enter Number of trip : ");
        number = in.nextInt();
        System.out.println("Enter Date of trip yy/mm/dd : ");
        date = in.next();
        // check if number of trip is already avalible with same data
        Trip t = getTrip(number);
        if (t != null && t.getDate().equals(date)){
            System.out.println("There are trip with same number");
            return;
        }
        System.out.println("Enter Max Number of Passangers : ");
        maxNumOfPassanger = in.nextInt();


        System.out.println("Enter Details of driver for this trip ");
        //public Driver(int id, String name, int age)
        System.out.println("Enter id of driver : ");
        id = in.nextInt();

        System.out.println("Enter name of driver : ");
        name = in.next();

        System.out.println("Enter age of driver : ");
        age = in.nextInt();
        // create the trip and add it to our collection
        Trip trip = new Trip(number, new Driver(id, name, age), date, maxNumOfPassanger);
        Trips.add(trip);
        System.out.println("Added");
    }
    /*
     * getTrip - return trip using trip number 
     * return null if there no trip with that number
     */
    public static Trip getTrip(int number){
        for (Trip trip : Trips){
            if (trip.getNumber() == number){
                return trip;
            }
        }
        return null;
    }
    /*
     * add passanger to specifi trip
     */
    public static void addToTrip(){
        int number;
        String name;
        int age;
        long nationalId;
        Passanger passanger;
        System.out.println("Enter Trip number : ");
        number = in.nextInt();
        Trip trip = getTrip(number);
        //check if trip already in  data or no
        if (trip == null){
            System.out.println("Trip not found !!");
        } 
        System.out.println("Enter Details of Passanger to add : ");
        //public Driver(int id, String name, int age)
        System.out.println("Enter national id of passanger : ");
        nationalId = in.nextInt();

        System.out.println("Enter name of passanger : ");
        name = in.next();

        System.out.println("Enter age of passanger : ");
        age = in.nextInt();
        passanger = new Passanger(name, age, nationalId);
        trip.addPassanger(passanger);
    }
    /*
     * removeTotrip - rmove passanger from trip
     */
    public static void removeToTrip(){
        int number;
        String name;
        int age;
        int nationalId;
        Passanger passanger;
        System.out.println("Enter Trip number : ");
        number = in.nextInt();
        Trip trip = getTrip(number);
        //check trip again
        if (trip == null){
            System.out.println("Trip not found !!");
        } 
        System.out.println("Enter Details of Passanger to add : ");
        System.out.println("Enter national id of passanger : ");
        nationalId = in.nextInt();

        System.out.println("Enter name of passanger : ");
        name = in.next();

        System.out.println("Enter age of passanger : ");
        age = in.nextInt();
        // create passanger object and add it to that trip
        passanger = new Passanger(name, age, nationalId);
        trip.removePassanger(passanger);
    }
    public static double avgPerDate(){
        String date;
        int numOfTrips = 0;
        int numOfPassangers = 0;
        Double average;
        System.out.println("Enter Date yy/mm/dd");
        date = in.next();
        for (Trip trip : Trips){
            if (trip.getDate().equals(date) == true){
                numOfTrips ++;
                numOfPassangers += trip.numOfPassangers();
            }
        }
        // to make sure that numoftrips is > 0 because of runtime error when we divible by 0
        if (numOfTrips == 0) numOfTrips = 1;
        // casting to double because int/int will give us int
        average = (double) (numOfPassangers / numOfTrips);
        return average;
        
    }
    public static void display(){

        for (String Date : Trip.Dates){
            System.out.print(Date + ":");
            for (Trip trip : Trips){
                if (trip.getDate().equals(Date)){
                    System.out.print("tripNO" + trip.getNumber());
                }
            }
            System.out.println("");
        }
    }

}
