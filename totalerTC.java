import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by apoko_000 on 12/9/2015.
 */
public class totalerTC {

    public void totaler() throws IOException{

        DecimalFormat posNegdollars = new DecimalFormat("+$##,###,###.00;-$##,###,###.00");
        DecimalFormat posNeg = new DecimalFormat("+##,###,###.##;-##,###,###.##");

    // Read the contract values from the file and assign each a variable
    File file = new File("C:\\Users\\andrew.pokorney\\IdeaProjects\\Assignments\\src\\final.txt");
    // Creates scanner object for input file
    Scanner inputFile = new Scanner(file);

    // Open the file for Scanner to read from
    file = new File("C:\\Users\\andrew.pokorney\\IdeaProjects\\Assignments\\src\\final.txt");
    inputFile = new Scanner(file);

        double totalContractsAPK = 0;
        double totalContractsGSEC = 0;
        double totalPremiumAPK = 0;
        double totalPremiumGSEC = 0;
        final double haircutLimit = 7200000;        //constant


        while (inputFile.hasNext()){
        String value1 = inputFile.next();		//APK buy sell quantity
        String value2 = inputFile.next();		//APK expiration date
        String value3 = inputFile.next();		//APK strike price
        String value4 = inputFile.next();		//APK call or put
        String value5 = inputFile.next();		//APK price
        String value6 = inputFile.next();		//GSEC buy sell quantity
        String value7 = inputFile.next();		//GSEC expiration date
        String value8 = inputFile.next();		//GSEC strike price
        String value9 = inputFile.next();		//GSEC call or put
        String value10 = inputFile.next();		//GSEC price
// Relevant data type converstions and new variable declarations
        double quantityAPK = Double.parseDouble(value1);			//converts value1 string to double
        double quantityGSEC = Double.parseDouble(value6);		//converts value6 string to double
        double premiumAPK = (Double.parseDouble(value5));		//converts value5 string to double
        double premiumGSEC = (Double.parseDouble(value10)); //converts value10 string to double
        double strikeAPK = (Double.parseDouble(value3));			//converts value3 string to double
        double strikeGSEC = (Double.parseDouble(value8));			//converts value8 string to double
        String expirationAPK = value2;
        String expirationGSEC = value7;
        String callPutAPK = value4;
        String callPutGSEC = value9;
// Calculations for variables outside of the loop. Allows count, totalContractsAPK and totalContractsGSEC to populate.
        totalContractsAPK = totalContractsAPK += quantityAPK;												//adds value1 as a column and stores outside the loop
        totalContractsGSEC = totalContractsGSEC += quantityGSEC;										//adds value6 as a column and stores outside the loop
        totalPremiumAPK = totalPremiumAPK += premiumAPK;					//multiplies value5 by value1 to get a quantity*price, store outside loop
        totalPremiumGSEC =totalPremiumGSEC+= ((premiumGSEC)*(quantityGSEC));		//multiplies value10 by value value6 to get a quantity*price, store outside loop

}



        System.out.println("Trader Statistics:");
        System.out.println("------------------");
        System.out.println("Total net contracts reported by APK: "+posNeg.format(totalContractsAPK));
        System.out.println("Total premium reported by APK: "+posNegdollars.format(totalPremiumAPK));
        double capitalSpent = (totalPremiumAPK*totalContractsAPK);
        System.out.println("Total capital expended on trading day: "+posNegdollars.format(capitalSpent));
        System.out.print("New Daily Haircut Limit: "+posNegdollars.format(haircutLimit-capitalSpent));

    }


}


