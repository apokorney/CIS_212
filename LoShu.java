

/**
 * Andrew Pokorney
 */

import java.util.*;
import java.util.Scanner;

public class LoShu {
    Scanner keyboard = new Scanner (System.in);

    int [] [] square = new int [3][3];

    public LoShu(){
        tOrF();
    }

 /*   for (row = 0; row < 3; row++)
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


    for (int row = 0; row < order; row++) {
        for (int col = 0; col < order; col ++) {
            sumRow[row] += square[row][col];
        }
    }

    for (int col = 0; col < order; col++) {
        for (int row = 0; row < order; row ++) {
            sumCol[col] += square[row][col];
        }
    }

    for (int row = 0; row < order; row++) {
        sumDiag[0] += square[row][row];
    }

    for(int row = 0; row < order; row++) {
        sumDiag[1] += square[row][order - 1 - row];
    }

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

*/
    public void tOrF(){
    String tOrF = "";
    if (true) {
        tOrF = "is";
    } else {
        tOrF = "is not";
    }}

}


