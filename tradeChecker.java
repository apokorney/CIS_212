import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;



public class tradeChecker {

    public static void main(String[] args) throws IOException {

        //formatter TC for formatted date and time
        formatterTC timeDate = new formatterTC();

        //Validate the file (in this case final.txt) is in the appropriate location
        fileValidatorTC fileCheck = new fileValidatorTC();
        fileCheck.fileValidation();

        //traceCheckerTotalsTC for totals calculations
        tradeCheckerTotalsTC newTotals = new tradeCheckerTotalsTC();
        //System.out.println(newTotals);
        //newTotals.tradeCheckerTotalsTC(double test);
        //newTotals.readValues();
        //newTotals.readValues();
        //System.out.println(newTotals.premiumAPK);
        newTotals.loopFile();

        tradeCheckerTotalsTC newString = new tradeCheckerTotalsTC();
        //newString.readString();


        //decimal format
        DecimalFormat posNeg = new DecimalFormat("+##,###,###.##;-##,###,###.##");
        DecimalFormat posNegdollars = new DecimalFormat("+$##,###,###.00;-$##,###,###.00");
        DecimalFormat contractOutput = new DecimalFormat("#.##");
        DecimalFormat time = new DecimalFormat("00");




    // Print out timestamp, totals, and diff report header

        System.out.println("\n-------------------------------------------------------------------------------------");	//85 dashes for formatting
        System.out.print("\t\t\t\t\tTrade Checker Run: "+timeDate);
        System.out.print("\n-------------------------------------------------------------------------------------");	//85 dashes for formatting
        //System.out.print("\n "+countAPK+" trades were executed on the prior trading day. Program run: "+
        System.out.print("\n\tContract Totals:");
        //System.out.print("\n\t\t "+(posNeg.format(totalContractsAPK))+" net contracts reported by APK");
        //System.out.println("\n\t\t "+(posNeg.format(totalContractsGSEC))+" net contracts reported by GSEC");
        //System.out.print("\n\tPremium Totals:");
        //System.out.print("\n\t\t "+(posNegdollars.format(totalPremiumAPK))+ " total dollar premium reported by APK");
        //System.out.println("\n\t\t "+(posNegdollars.format(totalPremiumGSEC))+" total dollar premium reported by GSEC");
        System.out.print("\n\tDiff Report Overview: ");


}
}




