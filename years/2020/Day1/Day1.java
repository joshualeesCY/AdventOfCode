package solutions;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner inFile = new Scanner(new File("inputs/1.in"));
        
        // TASK 1
        
        int[] arr = new int[200];
        int i = 0;
        int total = 0;
        int num1 = 0;
        int num2 = 0;
        while(inFile.hasNext()) {
            arr[i] = inFile.nextInt();
            i++;
        }
        
        for (int j = 0; j < 200; j++) {
            for(int k = j; k < 200; k++) {
                total = arr[j] + arr[k];
                if (total == 2020) {
                    num1 = arr[j];
                    num2 = arr[k];
                }
            }
        }
        System.out.println("task 1: " + num1 * num2);
        
        
        // TASK 2
        
        num1 = 0;
        num2 = 0;
        int num3 = 0;
        
        for (int j = 0; j < 200; j++) {
            for (int k = j; k < 200; k++) {
                for (int l = k; l < 200; l++) {
                    total = arr[j] + arr[k] + arr[l];
                    if (total == 2020) {
                        num1 = arr[j];
                        num2 = arr[k];
                        num3 = arr[l];
                    }
                }
            }
        }
        System.out.println("task 2: " + num1 * num2 * num3);
        inFile.close();
    }
}