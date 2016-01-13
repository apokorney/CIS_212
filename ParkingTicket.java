import java.io.File;
import java.util.Scanner;


public class ParkingTicket
{
    private double fine;
    private ParkedCar parkedcar;
    private ParkingMeter parkingmeter;
    private PoliceOfficer policeofficer;


    public ParkingTicket(double fine, ParkedCar pcar, ParkingMeter pmeter)
    {
        parkedcar = new ParkedCar(pcar);

        parkingmeter = new ParkingMeter(pmeter);


        this.fine = fine;
    }



    public String toString()
    {
        String str = "Illegally parked car info: " + parkedcar +
                "\nParking meter info:" + parkingmeter +
                "\nAmount of the fine...: " + fine;

        return str;
    }
}


