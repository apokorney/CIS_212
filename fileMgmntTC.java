import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Scanner;

/*public class fileMgmntTC {

    public void fileOption() throws IOException{
        System.out.println("Would you like to create a new output file?");
        Scanner keyboard = new Scanner(System.in);
        String userChoice = keyboard.nextLine();
        if (userChoice.equals("y")){

             try {
                FileWriter writer = new FileWriter("TradeChecker.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);

                tradeCheckerTotalsTC tradeCheckerFile = new tradeCheckerTotalsTC();

                 //bufferedWriter.write(tradeCheckerFile.loopFile());     //this doesnt work
                 bufferedWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }}
*/