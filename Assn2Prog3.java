/**
 * Created by Andrew Pokorney
 * Tossing Coins for a Dollar
 */

public class Assn2Prog3 {

        static final double dollarBal = 1.00;                //declaring constants static
        static final double qrtr = 0.25;                    //for multiple Class/method use (in Coin())
        static final double dme = 0.10;
        static final double nckl = 0.05;
        static double balance = 0;                          //holds the balance variable, start at $0
        static Coin quarter = new Coin();                   //create a quarter object of Coin class
        static Coin dime = new Coin();                      //create a dime dime object of Coin class
        static Coin nickel = new Coin();                    //Create a nickel class of Coin class

    public static void main(String args[]) {

            System.out.println("To win, your balance must reach exactly $1.00");
            System.out.println("A quarter, dime, and nickel will be flipped each round.");
            System.out.println("The coins which land heads up will be summed together each round.");
            System.out.println("Rounds will continue while your balance is under $1.00");

            while (balance < dollarBal) {                   //when balance < 1.00, keep flipping the 3 coins
                quarter.toss();                             //flip qrtr -- Simultaneously flip qrtr/dme/nckl
                dime.toss();                                //flip dme
                nickel.toss();                              //flip nckl

                if (isHeads(quarter)) {                   //add .25 if quarter is heads up (using isHeadUp() method below)
                    balance += qrtr;}

                if (isHeads(dime)) {                      //add .10 if quarter is heads up (using isHeadUp() method below)
                    balance += dme;}

                if (isHeads(nickel)) {                    //add .05 if quarter is heads up (using isHeadUp() method below)
                    balance += nckl;}
            } //end the while loop
            System.out.println("\n----------GAME IN PROGRESS---------");
            System.out.printf("\nYour ending Balance: $%,1.2f\n", balance);
            winLose();
        } //end of main method

    public static boolean isHeads(Coin coin) {            //determine if the coins are heads up
                                                            //return the value to while loop
            if (coin.getSideUp().equals("Heads")) {
                return true;
            } else {
                return false;
            }
        }

    public static void winLose(){                           //determines and ouputs winner/loser
            if (balance == dollarBal) {
                 System.out.println("We've got a winner, prepare for the showcase showdown!");
        }   else {
                    System.out.println("Better luck next time, thanks for playing!");
        }}

    }   //ends Assn2Prog3
