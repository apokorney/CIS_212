/**
 * Created by apoko_000 on 11/2/2015.
 */
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;
import java.util.Random;

//Roulette wheel = pockets 0-36
//Pocket 0 = green
//Pocket 1-10 = 1,3,5,7,9 are red. 2,4,6,8,10 are black
//Pocket 11-18 = 11,13,15,17 are black. 12,14,16,18 are red
//Pocket 19-28 = 19, 21, 23, 25, 27 are red. 20,22,24,26,28 are black
//Pocket 29-36 = 29, 31, 33, 35 are black. 30,32,34,36 are red
//Write a class called "RoulettePocket". The constructor should accept a pocket #.
//The RoulettePocket Class should have a method named getPocketColor that returns the pocket color (String)
//RoulettePocketTest should have the main method
//Demonstrate the class in a program that asks the user to enter a pocket number --Pocket test
//This class should display whether the pocket is green, red, or black --Pocket test
//Display an error message if the user enters a # outside 0-36 --Pocket test

public class RoulettePocket {
    private String pocketColor; //Color of the pocket
    private String pocketNumber; //Number of the pocket
    private int pocketInt; //convert String pocketNumber to Int

    public RoulettePocket(String pocket){
         pocketNumber = pocket;

    }

    //getPocketColor method, return the pocket color.
    public String getPocketColor(){
  //      logicTest();

        pocketInt = Integer.parseInt(pocketNumber);

        if (pocketInt == 0){pocketColor = "green";}

        if ((pocketInt >= 1) && (pocketInt <= 10)){
            if ((pocketInt % 2 == 0) && (pocketInt > 0)){pocketColor = "black";}
                else if ((pocketInt > 0) && (!(pocketInt%2==0))){
                pocketColor = "red";
            }
            else {pocketColor = "green";}
        }

        if ((pocketInt >= 11) && (pocketInt <= 18)){
            if ((pocketInt % 2 == 0) && (pocketInt > 0)){pocketColor = "red";}
            else if ((pocketInt > 0) && (!(pocketInt%2==0))){
                pocketColor = "black";
            }
            else {pocketColor = "green";}
        }
        if ((pocketInt >= 19) && (pocketInt <= 28)){
            if ((pocketInt % 2 == 0) && (pocketInt > 0)){pocketColor = "black";}
            else if ((pocketInt > 0) && (!(pocketInt%2==0))){
                pocketColor = "red";
            }
            else {pocketColor = "green";}}
        if ((pocketInt >= 29) && (pocketInt <= 36)){
            if ((pocketInt % 2 == 0) && (pocketInt > 0)){pocketColor = "red";}
            else if ((pocketInt > 0) && (!(pocketInt%2==0))){
                pocketColor = "black";
            }
            else {pocketColor = "green";}}

        return pocketColor;
    }

 //   public void logicTest(){
 //       pocketInt = Integer.parseInt(pocketNumber);
 //       if ((pocketInt < 0) || pocketInt > 36){
 //           System.out.println("You entered the number "+pocketInt+ " which is not valid. Please enter a number between 0 and 36.");
 //       }

    }



