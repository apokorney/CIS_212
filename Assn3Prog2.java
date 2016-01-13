
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Assn3Prog2
{
    public static void main (String[ ] args) throws IOException
    {

        Scanner in = new Scanner(new File("C:\\Program Files\\Java\\jdk1.8.0_31\\bin\\Assn3Prog2text.txt"));

        String make = in.nextLine();
        String model = in.nextLine();
        String color = in.nextLine();
        String license = in.nextLine();
        int mins = in.nextInt();


        ParkedCar myParkedCar = new ParkedCar(make, model, color, license, mins);

        ParkingMeter myParkingMeter = new ParkingMeter(mins);


        PoliceOfficer myPoliceOfficer = new PoliceOfficer("Officer 1", 1337, myParkedCar, myParkingMeter);
        PoliceOfficer myPoliceOfficer2 = new PoliceOfficer("Officer 2", 1338, myParkedCar, myParkingMeter);

        myPoliceOfficer.inspectParkedCar();
        myPoliceOfficer2.inspectParkedCar();

        ParkingTicket myParkingTicket = new ParkingTicket(myPoliceOfficer.fine, myParkedCar, myParkingMeter);
        myParkingTicket.toString();

        myParkedCar.toString();

        System.out.println(myParkedCar);


    }
}


