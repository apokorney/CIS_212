import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

class tradeCheckerTotalsTC {
    double totalPremiumAPK = 0;
    double totalPremiumGSEC = 0;


    public double totalContractsAPK, totalContractsGSEC, contractDiff, premiumDiff,
            totalStrikeAPK, totalStrikeGSEC, premiumAPK, premiumGSEC, strikeAPK, strikeGSEC;
    public String expirationAPK, expirationGSEC, callPutAPK, callPutGSEC;
    public int countAPK;


    public tradeCheckerTotalsTC() throws IOException {      //constructor
        // Create count and totalContractsAPK variables
        int countAPK = 0;
        double totalContractsAPK = 0;
        double totalContractsGSEC = 0;
        double contractDiff = 0;
        double premiumDiff = 0;
        double totalStrikeAPK = 0;
        double totalStrikeGSEC = 0;
        }


    public void loopFile() throws IOException {
        // Read the contract values from the file and assign each a variable
        File file = new File("C:\\Users\\andrew.pokorney\\IdeaProjects\\Assignments\\src\\final.txt");
        // Creates scanner object for input file
        Scanner inputFile = new Scanner(file);

        // Open the file for Scanner to read from
        file = new File("C:\\Users\\andrew.pokorney\\IdeaProjects\\Assignments\\src\\final.txt");
        inputFile = new Scanner(file);

        int tradesNumTotal = 0;
        //Loop through the text file, line by line
        while(inputFile.hasNextLine()){
            readValues(inputFile);
            inputFile.nextLine();
            tradesNumTotal++;
        }
        System.out.println("\nTotal number of trades processed: "+tradesNumTotal);

    }



    public void readValues(Scanner inputFile)throws IOException {  //this method reads from text file and converts numbers to doubles
         /*
        // Read the contract values from the file and assign each a variable
        */
        //create an ArrayList
        ArrayList<String> listValues = new ArrayList<String>();

        //Loop through the 10 items on each line of the text file.
        int i = 0;
        double totalquantityAPK = 0;
        while (i <10) {
        String value1 = inputFile.next();
        listValues.add(value1);
        i++;}

        double quantityAPK = Double.parseDouble(listValues.get(0));             //converts value1 string to double
        double quantityGSEC = Double.parseDouble(listValues.get(5));            //converts value6 string to double
        double premiumAPK = (Double.parseDouble(listValues.get(4)));            //converts value5 string to double
        double premiumGSEC = (Double.parseDouble(listValues.get(9)));           //converts value10 string to double
        double strikeAPK = (Double.parseDouble(listValues.get(2)));             //converts value3 string to double
        double strikeGSEC = (Double.parseDouble(listValues.get(7)));            //converts value8 string to double
        double premiumDiff = premiumAPK - premiumGSEC;                          //differences in prices
        double quantityDiff = quantityAPK-quantityGSEC;                         //differences in quantity
        double strikeDiff = strikeAPK-strikeGSEC;
        String quantityDiffString = Double.toString(quantityDiff);              //use wrapper class to convert to string
        String strikeDiffString = Double.toString(strikeDiff);                  //use wrapper class to convert to string

        DecimalFormat posNeg = new DecimalFormat("+##,###,###.##;-##,###,###.##");
        DecimalFormat posNegdollars = new DecimalFormat("+$##,###,###.00;-$##,###,###.00");
        DecimalFormat contractOutput = new DecimalFormat("###,###");
        String tradeDefinition = tradePrinter()+posNeg.format(quantityAPK)+" "+listValues.get(1)+" "+listValues.get(2)+" "+listValues.get(3)+" "+listValues.get(4)+"\n";



        if (!(quantityAPK == quantityGSEC)) {
            System.out.println("There is a quantity diff, APK knows: " + posNeg.format(quantityAPK) + "\tGSEC knows: " + posNeg.format(quantityGSEC));
            System.out.println("There is a differnce of "+posNeg.format(quantityDiff)+" contracts, resulting in "+posNegdollars.format(quantityDiff*premiumAPK)+" in market risk");
            System.out.println(tradeDefinition);


        }
        if (!(premiumAPK == premiumGSEC)) {
            System.out.println("There is a premium diff, APK knows: " + premiumAPK + " \tGSEC knows: " + premiumGSEC);
            System.out.println("Monetary difference in prices = "+posNegdollars.format(premiumDiff)+" resulting in "+posNegdollars.format(premiumDiff*quantityAPK)+" of market risk");
            System.out.println(tradeDefinition);

        }
        if (!(strikeAPK == strikeGSEC)) {
            System.out.println("There is a strike diff, APK knows: " + contractOutput.format(strikeAPK) + "\tGSEC knows: " + contractOutput.format(strikeGSEC));
            System.out.println("There is a difference of "+strikeDiff+" points between strikes");
            System.out.println(tradeDefinition);
        }

        String expirationAPK = listValues.get(1);
        String expirationGSEC = listValues.get(6);
        String callPutAPK = listValues.get(3);
        String callPutGSEC = listValues.get(8);

        if (!expirationAPK.equals(expirationGSEC)) {
            System.out.println("There is an expiration diff, APK knows: " + expirationAPK + "\tGSEC knows: " + expirationGSEC);
            System.out.println(tradeDefinition);
        }
        if (!callPutAPK.equals(callPutGSEC)) {
            System.out.println("There is a call/put diff, APK knows: " + callPutAPK + "\tGSEC knows: " + callPutGSEC);
            System.out.println(tradeDefinition);
        }


    }




    public String tradePrinter(){
        String tradePrinter = "In APK's system: ";
        return tradePrinter;
    }




    public void readString(Scanner inputFile)throws IOException {    //this method allows the return of a String

        // Read the contract values from the file and assign each a variable

        ArrayList<String> listString = new ArrayList<String>();                   //dynamic array
        while (inputFile.hasNext()) {
            String value1 = inputFile.next();
            listString.add(value1);
        }

            String expirationAPK = listString.get(1);
            String expirationGSEC = listString.get(6);
            String callPutAPK = listString.get(3);
            String callPutGSEC = listString.get(8);

            if (!expirationAPK.equals(expirationGSEC)) {
                System.out.println("There is an expiration diff, APK knows: " + expirationAPK + "\tGSEC knows: " + expirationGSEC);
            }
            if (!callPutAPK.equals(callPutGSEC)) {
                System.out.println("There is a call/put diff, APK knows: " + callPutAPK + "\tGSEC knows: " + callPutGSEC);
            }



            }




      //tradeCheckerTotals()

    public tradeCheckerTotalsTC(int countAPK, double totalContractsAPK, double totalContractsGSEC, double totalPremiumAPK, double totalPremiumGSEC, double contractDiff,
                                double premiumDiff, double totalStrikeAPK, double totalStrikeGSEC, String callPutMessage, String expirationMessage,
                                double quantityAPK, double quantityGSEC, double premiumAPK, double premiumGSEC, double strikeAPK, double strikeGSEC, String countAPKstring,
                                String callPutAPK, String callPutGSEC, String expirationAPK, String expirationGSEC){

        this.countAPK = countAPK;
        this.premiumAPK = premiumAPK;
        this.premiumGSEC = premiumGSEC;
        this.strikeAPK = strikeAPK;
        this.strikeGSEC = strikeGSEC;
        this.callPutAPK = callPutAPK;
        this.callPutGSEC = callPutGSEC;
        this.expirationAPK = expirationAPK;
        this.expirationGSEC = expirationGSEC;
        this.totalContractsAPK = totalContractsAPK;
        this.totalContractsGSEC = totalContractsGSEC;
        this.totalPremiumAPK = totalPremiumAPK;
        this.totalPremiumGSEC = totalPremiumGSEC;
        this.contractDiff = contractDiff;
        this.premiumDiff = premiumDiff;
        this.totalStrikeAPK = totalStrikeAPK;
        this.totalStrikeGSEC = totalStrikeGSEC;
    }


} //end tradeCheckerTotalsTC class