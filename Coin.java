/**
 * Created by Andrew Pokorney
 */


import java.util.Random;

public class Coin {
    private String sideUp;              //initialize sideUp in Coin class


    public Coin() {                     //no arg constructor for Coin class, calls toss() method
        // initialize sideUp
        toss();
    }


    public void toss() {                //void method simulating the toss, sets sideUp variable

        Random rand = new Random();

        int value = rand.nextInt(2);    //creates 2 random outcomes 0, 1 and stores in value

        if (value == 0) {               //Logic to determine heads/tails given 0/1 random value
            this.sideUp = "Heads";
        } else {
            this.sideUp = "Tails";
        }
    }


    public String getSideUp() {         //return method that returns sideUp variable
        return sideUp;
    }
}
