/**
 * Created by apoko_000 on 11/2/2015.
 */
import java.util.Scanner;
import java.util.Random;

//Roulette wheel = pockets 0-36
//Pocket 0 = green
//Pocket 1-10 = 1,3,5,7,9 are red. 2,4,6,8,10 are black
//Pocket 11-18 = 11,13,15,17 are black. 12,14,16,18 are red
//Pocket 19-28 = 19, 21, 23, 25, 27 are red. 20,22,24,26,28 are black
//Pocket 29-36 = 29, 31, 33, 35 are black. 30,32,34,36 are black
//Write a class called "RoulettePocket". The constructor should accept a pocket #.
//The RoulettePocket Class should have a method named getPocketColor that returns the pocket color (String)
//RoulettePocketTest should have the main method
//Demonstrate the class in a program that asks the user to enter a pocket number
//This class should display whether the pocket is green, red, or black
//Display an error message if the user enters a # outside 0-36

public class RoulettePocketTest {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Please provide a pocket number between 0 and 36: ");
        String userPocketNumber = input.nextLine();
        String userPocketColor ="";
        int pocketNumberInt;

        pocketNumberInt = Integer.parseInt(userPocketNumber);

        while (pocketNumberInt >= 0  && pocketNumberInt <= 36){
        RoulettePocket rouletteObject = new RoulettePocket(userPocketNumber);
        System.out.println("You entered the number " + userPocketNumber + " which is the color " + rouletteObject.getPocketColor());
            System.out.print("Please provide a pocket number to play again or enter 99 to quit: ");
            userPocketNumber = input.nextLine();
            pocketNumberInt = Integer.parseInt(userPocketNumber);
            if(pocketNumberInt == 99){
                System.exit(0);
            }
        }

        while ((pocketNumberInt < 0)  || (pocketNumberInt > 36)){
            System.out.println("You entered the number "+pocketNumberInt+ " which is not valid. Please enter a number between 0 and 36.");
            System.out.println("Please provide a pocket number or enter 99 to quit: ");
            userPocketNumber = input.nextLine();
            pocketNumberInt = Integer.parseInt(userPocketNumber);
            RoulettePocket rouletteObject = new RoulettePocket(userPocketNumber);
            if(pocketNumberInt == 99){
                System.exit(0);

        }
                 while (pocketNumberInt >= 0  && pocketNumberInt <= 36){
                 rouletteObject = new RoulettePocket(userPocketNumber);
                System.out.println("You entered the number " + userPocketNumber + " which is the color " + rouletteObject.getPocketColor());
                System.out.print("Please provide a pocket number to play again or enter 99 to quit: ");
                userPocketNumber = input.nextLine();
                pocketNumberInt = Integer.parseInt(userPocketNumber);
                if(pocketNumberInt == 99){
                    System.exit(0);
                }}

        }}
    }



