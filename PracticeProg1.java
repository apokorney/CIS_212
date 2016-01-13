/**
 * Created by andrew.pokorney on 10/1/2015.
 */
import java.util.Scanner;
import java.io.*;

//main method
public class PracticeProg1 {
    public static void main(String[] args) throws IOException {

// Create a Scanner object to read input.
        Scanner keyboard = new Scanner(System.in);

//variable declaration
        int calories;
        int caloriesTemp;
        int fat;
        double caloriesFat;
        double caloriesFatPercent;
        String foodType;

// Get Food Name from user
        System.out.print("Enter Food Name: ");
        foodType = keyboard.nextLine();

// Get Total calories from user
        System.out.print("Enter total calories: ");
        calories = keyboard.nextInt();
        if (calories == -99) {
            System.exit(0);
        }
        while ((calories < 1 ) || (calories > 5000)){
            if (calories == -99) {
                System.exit(0);
            }
            System.out.println("You've entered a calorie amount less than 1 or greater than 5000");
            System.out.print("Enter new total calories");
            System.out.println(" or enter -99 to quit");
            calories = keyboard.nextInt();}

//Get fat total from user
        System.out.print("Enter total grams of fat: ");
        fat = keyboard.nextInt();
        if (fat == -99) {
            System.exit(0);
        }
        while ((fat < 0 ) || (fat > calories)){
            if (fat == -99) {
                System.exit(0);
            }
            System.out.println("You've entered a fat amount less than 0 or greater than calories");
            System.out.print("Enter new fat");
            System.out.println(" or enter -99 to quit");
            fat = keyboard.nextInt();}

//Output vairable calculation
        caloriesFat = (fat * 9);

//Output logic
        if (calories > 1 && fat >= 0) {
            caloriesTemp = calories;
            caloriesFatPercent = ((caloriesFat/caloriesTemp) * 100);
            System.out.println("The percentage of calories from fat is: " + caloriesFatPercent + "%");}
        if ((((caloriesFat / calories) * 100) < 30) && (fat >= 0)) {
            System.out.println(foodType + " is a low fat food!");}
        if (((((caloriesFat / calories) * 100) < 70)) && (((caloriesFat/calories)*100) > 30)) {
            System.out.println(foodType + " is a moderately fat food!");}
        if (((caloriesFat / calories) * 100) > 70) {
            System.out.println(foodType + " is a high in fat food!");}

//Print to file
        PrintWriter outputFile = new PrintWriter("fatGramCalculator.txt");
        outputFile.println("foodType" + "\t" + "calories" + "\t "+ "fat" + "\t\t "+ "caloriesFat");
        outputFile.println(foodType + "\t\t" + calories + "\t\t "+ fat + "\t\t "+ caloriesFat);
        outputFile.close();

    }}