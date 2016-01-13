import java.io.File;
import java.util.Scanner;


public class PoliceOfficer
{
    private String name;
    private int badgeNumber;
    private ParkedCar parkedcar;
    private ParkingMeter parkingmeter;
    private ParkingTicket parkingticket;
    public double fine = 0;


    public PoliceOfficer(String poname, int pobnumber, ParkedCar pcar, ParkingMeter pmeter)
    {
        name = poname;
        badgeNumber = pobnumber;


        parkedcar = new ParkedCar(pcar);


        parkingmeter = new ParkingMeter(pmeter);
    }


    public void set(String poname, int pobnumber)
    {
        name = poname;
        badgeNumber = pobnumber;
    }

    /** The copy constructor initializes the object
     as a copy of another PoliceOfficer object.
     @param object2 The object to copy.
     */

    public PoliceOfficer(PoliceOfficer object2)
    {
        name = object2.name;
        badgeNumber = object2.badgeNumber;

    }

    public ParkedCar getParkedCar()
    {
        return new ParkedCar(parkedcar);
    }

    public ParkingMeter getParkingMeter()
    {
        return new ParkingMeter(parkingmeter);
    }

    public void inspectParkedCar()
    {
        if (parkedcar.minutes > parkingmeter.minutesPurchased)
            if (parkedcar.minutes - parkingmeter.minutesPurchased <= 60)
                fine = 25;
            else
                fine = 25 + (10 * ((parkedcar.minutes - parkingmeter.minutesPurchased) / 60));


        parkingticket = new ParkingTicket(fine, parkedcar, parkingmeter);
    }
}

