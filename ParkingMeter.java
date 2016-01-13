import java.io.File;
import java.util.Scanner;


public class ParkingMeter
{
    public int minutesPurchased; // n# minutes of parking time t

    public ParkingMeter(int pmmpurchased)
    {
        minutesPurchased = pmmpurchased;
    }

    public void set(int pmmpurchased)
    {
        minutesPurchased = pmmpurchased;
    }

    public ParkingMeter(ParkingMeter object2)
    {
        minutesPurchased = object2.minutesPurchased;
    }

    public int getMintuesPurchased()
    {
        return minutesPurchased;
    }
}


