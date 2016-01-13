/**
 * Created by Andrew Pokorney
 */

import java.util.*;
import java.util.Scanner;

//write a method that accepts a 2-deminsional array as an arugment, and determines
//whether the array is a los shu magic square or not. Test the function in LoShuTest.java

    public class LoShuTest {

        public static void main(String[] args) {


            Scanner keyboard = new Scanner (System.in);

            int [] [] square = new int [3][3];

            for (int row = 0; row < 3; row++)
            {
                for (int col = 0; col < 3; col++)
                {
                    System.out.println("Input value for row " + (row+1) + " column " + (col+1));
                    square[row][col] = keyboard.nextInt();
                }
            }

            int order = square.length;

            int[] sumRow = new int[order];
            int[] sumCol = new int[order];
            int[] sumDiag = new int[2];

            Arrays.fill(sumRow, 0);
            Arrays.fill(sumCol, 0);
            Arrays.fill(sumDiag, 0);

            for (int row = 0; row < order; row++) {
                for (int col = 0; col < order; col ++) {
                    sumRow[row] += square[row][col];
                }
                System.out.println("sum row " + row+1 + "\n" + sumRow[row]);
            }

            for (int col = 0; col < order; col++) {
                for (int row = 0; row < order; row ++) {
                    sumCol[col] += square[row][col];
                }
                System.out.println("sum columns " + col+1 + "\n" + sumCol[col]);
            }

            for (int row = 0; row < order; row++) {
                sumDiag[0] += square[row][row];
            }
            System.out.println("sum diagonal 1 " + "\n" + sumDiag[0]);

            for(int row = 0; row < order; row++) {
                sumDiag[1] += square[row][order - 1 - row];
            }
            System.out.println("sum diagonal 2 " + "\n" + sumDiag[1]);

            boolean bool = true;

            int sum = sumRow[0];
            for (int i = 1; i < order; i++) {
                bool = bool && (sum == sumRow[i]);
            }
            for (int i = 0; i < order; i++) {
                bool = bool && (sum == sumCol[i]);
            }
            for (int i = 0; i < 2; i++) {
                bool = bool && (sum == sumDiag[i]);
            }

            String tOrF = "";
            if (bool) {
                tOrF = "is";
            } else {
                tOrF = "is not";
            }
            System.out.println("This " + tOrF + " a magic square.");


        }
    }

