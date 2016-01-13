import java.util.Scanner;

/**
 * Created by apoko_000 on 11/17/2015.
 */
public class LyricDemo {

    public static void main(String[] args) {

        //4 methods to be used
        //enterInput validateInput calculateTotals displayOutput
        enterInput();


    }


        public static void enterInput(){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Please Provide the list of Patron's ages and 2 letter state codes (separated by a space): ");
            System.out.println("To add an additional entry, use the return key immediately after the 2 letter state code.");
            System.out.println("For example: 11<space>FL<return>");
            int age = keyboard.nextInt();


        }




}
