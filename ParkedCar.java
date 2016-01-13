import java.io.File;
import java.util.Scanner;


public class ParkedCar
{
    private String make;
    private String model;
    private String color;
    private String licenseNumber;
    public int minutes;


    public ParkedCar(String pcmake, String pcmodel, String pccolor, String pclnumber, int pcminutes)
    {
        make = pcmake;
        model = pcmodel;
        color = pccolor;
        licenseNumber = pclnumber;
        minutes = pcminutes;
    }


    public void set(String pcmake, String pcmodel, String pccolor, String pclnumber, int pcminutes)
    {
        make = pcmake;
        model = pcmodel;
        color = pccolor;
        licenseNumber = pclnumber;
        minutes = pcminutes;
    }


    public ParkedCar(ParkedCar object2)
    {
        make = object2.make;
        model = object2.model;
        color = object2.color;
        licenseNumber = object2.licenseNumber;
        minutes = object2.minutes;
    }



    public String toString()
    {
        String str = "Parked car's make: " + make +
                "\nParked car's model: " + model +
                "\nParked car's color: " + color +
                "\nParked car's license plate number: " + licenseNumber +
                "\nMinutes that the car has been parked: " + minutes;

        return str;
    }
}


