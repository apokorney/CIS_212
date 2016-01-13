import java.io.IOException;

public class tradeCheckerTest {

    public static void main(String[] args) throws IOException {

        //Validate the file (in this case final.txt) is in the appropriate location
        fileValidatorTC fileCheck = new fileValidatorTC();
        fileCheck.fileValidation();

        // Print out header (timestamp, totals, and diff report header)
        headerTC printHeader = new headerTC();
        printHeader.header();

        //read totaler method from totaler class for diff analysis
        totalerTC totaler = new totalerTC();
        totaler.totaler();

        //body formatter
        printHeader.separator();



        //traceCheckerTotalsTC for individual trade checker values
        tradeCheckerTotalsTC newTotals = new tradeCheckerTotalsTC();
        newTotals.loopFile();

        //end dash formatter
        System.out.println(printHeader.ender());



    }
}
