/**
 * Created by Andrew Pokorney
 */



public class CoinTest {

    static final int tossNum = 20;                                          //declares static limit of tosses

    public static void main(String[] args) {
        int headsUP = 0;                                                      //declare counter for # of Heads
        Coin coinToss = new Coin();                                         //create object from Coin Class

        for (int i = 1; i <= tossNum; i++) {                                 //loop through 20 coin flips
            coinToss.toss();                                                //instantiate coinToss obj w/ toss method
            System.out.println("Toss " + i + ": " + coinToss.getSideUp());  //Print results for 2-20 coin flips


            if (coinToss.getSideUp() == "Heads") {                          //count++ headsUP, case Matters (30 minutes gone!!)
                headsUP++;
            }}                                                                       //end of the for loop

        System.out.print("The 20 tosses generated " + headsUP + " heads ");           //output total num heads
        System.out.println("and " + (20-headsUP) + " tails");                       //output total num tails

            }
    }


