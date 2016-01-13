/**
 * Created by andrew.pokorney on 10/19/2015.
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class Assn1Prog1 {
    public static void main(String[] args) {

        int numberOfWeeks, numberOfDays;
        int numberOfDaysZeroRain = 0;
        double totalRainfall = 0;
        double averageRainfallPerDay = 0;
        double averageRainfallPerWeek =0;
        int[] rainArray;
        rainArray = new int[7];

                double accumulatedRainfall = 0;
                DecimalFormat formatter = new DecimalFormat("0.00");

                Scanner input = new Scanner(System.in);

                System.out.println("Enter the number of weeks: ");
                numberOfWeeks = input.nextInt();

                numberOfDays = numberOfWeeks * 7;

                     for (int week = 1; week <= numberOfWeeks; week++) {
                    int count = 0;
                    int countZero = 0;
                    do {
                        Scanner inputRainfall = new Scanner(System.in);
                        System.out.println("Enter the rainfall for each day:");

                        totalRainfall = inputRainfall.nextDouble();

                        if (totalRainfall == 0){numberOfDaysZeroRain = numberOfDaysZeroRain+countZero+1;}

                        while (totalRainfall < 0) //Input Validation
                        {
                            System.out.println("No negative numbers! Terminating program!");
                            System.exit(0);
                        }


                        accumulatedRainfall += totalRainfall;
                        count++;
                        System.out.println("day: " + count + ", week: " + week);
            } while (count < 7);{

                System.out.println(week + " week(s) of entry ");
            }
        }

        averageRainfallPerDay = accumulatedRainfall / numberOfDays;

        System.out.println("Number of Days: " + numberOfDays);
        System.out.println("Number of Days without Rain: " + numberOfDaysZeroRain );
        System.out.println("Total rainfall: " + accumulatedRainfall + " inches");
        System.out.println("Average rainfall per day: " + formatter.format(averageRainfallPerDay) + " inches");
        System.out.println("Average rainfall per week: " + (accumulatedRainfall/numberOfWeeks));

    }}