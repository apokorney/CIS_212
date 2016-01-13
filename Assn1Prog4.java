//Andrew Pokorney Assn1Prog4

import java.util.Random;
import java.util.Scanner;
import java.io.*;


public class Assn1Prog4 {

    public static void main(String[] args) {
        String rpsString;
        String rpsCpuString;
        String player = "";
        String cpu = "";
        String output;
        double userWin = 0;
        double userLose = 0;

        Scanner keyboard = new Scanner(System.in);

        do{
        player = userSelection(keyboard);
        cpu = computerChoice();
        output = winner(cpu, player);
        System.out.println(output);
            if (output.equals("Rock beats scissors.\nThe user wins!") || (output.equals("Paper beats rock.\nThe user wins!")) || (output.equals("Scissors beats paper.\nThe user wins!"))) {
                userWin = userWin + 1;}
            if (output.equals("Paper beats rock.\nThe computer wins!") || (output.equals("Scissors beats paper.\nThe computer wins!")) || (output.equals("Rock beats scissors.\nThe computer wins!"))) {
                userLose = userLose + 1;
            }
            System.out.println("The user has won "+userWin+" games");
            System.out.println("The computer has won "+userLose+" games");
            System.out.println("The user's winning percentage is "+(userWin/(userWin+userLose))*100+"%\n");
            while("The game is tied!\nPlay again to break the tie!".equals(output)) {
            player = userSelection(keyboard);
            cpu = computerChoice();
            output = winner(cpu, player);
            System.out.println(output);
                if (output.equals("Rock beats scissors.\nThe user wins!") || (output.equals("Paper beats rock.\nThe user wins!")) || (output.equals("Scissors beats paper.\nThe user wins!"))) {
                    userWin = userWin + 1;}
                if (output.equals("Paper beats rock.\nThe computer wins!") || (output.equals("Scissors beats paper.\nThe computer wins!")) || (output.equals("Rock beats scissors.\nThe computer wins!"))) {
                    userLose = userLose + 1;
                }
                System.out.println("The user has won "+userWin+" games");
                System.out.println("The computer has won "+userLose+" games");
                System.out.println("The user's winning percentage is "+((userWin)/(userWin+userLose))*100+"%\n");
        }}while(!"The game is tied!\nPlay again to break the tie!".equals(output));

    }








    //user selection method
    public static String userSelection(Scanner keyboard){
        System.out.println("Choose 1 for Rock\nChoose 2 for Paper\nChoose 3 for Scissors\nChoose 99 to Quit");
        int userChoice = keyboard.nextInt();
        String userChoiceString = createChoice (userChoice);
        if (userChoice == 99 ){
            quit();}
        //validation
        for(int i = 0; userChoiceString == null; i++){
            System.out.println("You have chosen an invalid entry 3 total tries until termination.");
            System.out.println("Choose 1 for Rock\nChoose 2 for Paper\nChoose 3 for Scissors\nChoose 99 to Quit");
            userChoice = keyboard.nextInt();
            userChoiceString = createChoice (userChoice);
            if(userChoiceString == null){
                System.out.println("You have chosen an invalid entry 2 total tries until termination.");
                System.out.println("Choose 1 for Rock\nChoose 2 for Paper\nChoose 3 for Scissors\nChoose 99 to Quit");
                userChoice = keyboard.nextInt();
                userChoiceString = createChoice (userChoice);
                if (userChoiceString == null){
                    System.out.println("You have chosen an invalid entry 1 total tries until termination.");
                    System.out.println("Choose 1 for Rock\nChoose 2 for Paper\nChoose 3 for Scissors\nChoose 99 to Quit");
                    userChoice = keyboard.nextInt();
                    userChoiceString = createChoice (userChoice);
                    if (userChoiceString == null){
                        quit();
                    }
                }
                if (userChoice == 99 ){
                    quit();
                }
                while(i > 1){
                    System.exit(0);}}
        }
        return userChoiceString;}


    public static String createChoice(int num){
        String choice;
        switch (num){
            case 1:
                choice = "rock";
                break;
            case 2:
                choice = "paper";
                break;
            case 3:
                choice = "scissors";
                break;
            case 4:
                choice = "quit";
            default:
                choice = null;
        }
        return choice;
    }


    //quit method
    public static void quit(){
        System.exit(0);
    }

    //computer choice generation method
    public static String computerChoice() {
        Random rand = new Random();
        // 1-3 random generation
        int num = rand.nextInt(3) + 1;
        return createChoice (num) ;
    }

    //winner decision logic
    public static String winner(String computerChoice, String userSelection){
            String output ="";

        if (userSelection.equalsIgnoreCase("rock")) {
            if (computerChoice.equalsIgnoreCase("scissors"))
                output = "Rock beats scissors.\nThe user wins!";
            else if (computerChoice.equalsIgnoreCase("paper"))
                output = "Paper beats rock.\nThe computer wins!";
            else
                output = ("The game is tied!\nPlay again to break the tie!");
        } else if (userSelection.equalsIgnoreCase("paper")) {
            if (computerChoice.equalsIgnoreCase("scissors"))
                output = "Scissors beats paper.\nThe computer wins!";
            else if (computerChoice.equalsIgnoreCase("rock"))
                output = "Paper beats rock.\nThe user wins!";
            else
                output = ("The game is tied!\nPlay again to break the tie!");
        } else if (userSelection.equalsIgnoreCase("scissors")) {
            if (computerChoice.equalsIgnoreCase("rock"))
                output = "Rock beats scissors.\nThe computer wins!";
            else if (computerChoice.equalsIgnoreCase("paper"))
                output = "Scissors beats paper.\nThe user wins!";
            else
                output = ("The game is tied!\nPlay again to break the tie!");
                    }
        return output;    }







}