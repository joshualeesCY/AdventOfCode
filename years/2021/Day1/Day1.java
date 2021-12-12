package solutions;

import java.util.*;
import java.io.*;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        int[] intArr = new int[2005];
        
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = 0;
        }
        
        Scanner inFile = new Scanner(new File("inputs/1.in"));
        
        // FIRST TASK
        
        int item = 0;
        int prev = 0;
        int numInc = 0;
        int j = 0;
        prev = inFile.nextInt();
        
        while(inFile.hasNext()) {
            item = inFile.nextInt();
            intArr[j] = item;

            if (item > prev) {
                numInc++;
            }
            
            j++;
            prev = item;
        }
        
        // SECOND TASK
        
        int sum = 0;
        int prevSum = 0;
        int numSumInc = 0;
        
        for (int i = 0; i < intArr.length - 3; i++) {
            sum = intArr[i] + intArr[i + 1] + intArr[i + 2];
            
            if (sum > prevSum) {
                numSumInc++;
            }
            prevSum = sum;
        }
        
        System.out.println("task 1: " + numInc);
        System.out.println("task 2: " + numSumInc);
        inFile.close();
    }
}