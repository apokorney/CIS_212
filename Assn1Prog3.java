import java.util.Scanner;
import java.lang.Math;

public class Assn1Prog3 {

    public static void main(String[] args) {
        // Scanner object to get input
        Scanner numbers  = new Scanner(System.in);

        // Ask for Future value (F)
        System.out.print("Future value? ");
        double futureValue = numbers.nextDouble();

        // Ask for Interest rate (r)
        System.out.print("Input annual interest rate (actual rate, not percentage)?: ");
        double annualInterestRate = numbers.nextDouble();

        // Ask for Number of years (N)
        System.out.print("Number of years? ");
        int numberOfYears = numbers.nextInt();

        double neededValue = presentValue(futureValue, annualInterestRate, numberOfYears);

        //Numeric validation input
        if ((futureValue < 0) || (annualInterestRate < 0) || (numberOfYears < 0)){
            System.out.println("Negative Numbers not allowed, program terminating");
            System.exit(0);
        }

        // Notify user of amount needed to invest
        System.out.printf("Invest $%.2f ", neededValue);
        System.out.printf("to reach $%.2f ",futureValue);
        System.out.println("in " + numberOfYears + " years at a " + (annualInterestRate * 100) + "% interest rate." );
    }

   //PV calc method
    public static double presentValue(double futureValue, double annualInterestRate, int numberOfYears) {

        return futureValue / Math.pow((1 + annualInterestRate), numberOfYears);
    }

    }