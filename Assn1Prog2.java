
import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.*;

public class Assn1Prog2 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        double selection;
        double meters;
        //User line input
        do{
        System.out.print("Enter a distance in meters: ");
        meters = keyboard.nextDouble();
            while(meters < 0){
                System.out.print("No Negatives allowed! Enter a distance in meters: ");
                meters = keyboard.nextDouble();
            }
        menu();
        selection = keyboard.nextDouble();
        if (selection == 1){
            showKilometers(meters);
        }
        if (selection == 2){
            showInches(meters);
        }
        if (selection == 3){
            showFeet(meters);
        }
        if (selection == 4){
            quit();}
        if (selection < 1 || selection > 4){
            System.out.println("Invalid selection, Enter a valid selection 1-4; ");
            selection = keyboard.nextDouble();
        }
        }

        while(!(selection == 4));

    }

        //showKilometers method
        public static void showKilometers(double num1){
            DecimalFormat df = new DecimalFormat("#.########");
            double kilometers = num1*.001;
            System.out.println(num1 + " meters is " + df.format(kilometers) + " kilometers.");

    }

        //showInches method
        public static void showInches(double num2){
            DecimalFormat df2 = new DecimalFormat("#.########");
        double inches = num2*39.37;
            System.out.println(num2 + " meters is " + df2.format(inches) + " inches.");
        }

        //showFeet method
        public static void showFeet(double num3){
            DecimalFormat df3 = new DecimalFormat("#.########");
        double feet = num3*3.281;
                System.out.println(num3+" meters is "+ df3.format(feet) + " feet.");
        }

        //menu method
        public static void menu(){
            System.out.println("1. Convert to kilometers");
            System.out.println("2. Convert to Inches");
            System.out.println("3. Convert to feet");
            System.out.println("4. Quit the program");
        }

        //quit method
        public static void quit(){
            System.exit(0);
        }


}
