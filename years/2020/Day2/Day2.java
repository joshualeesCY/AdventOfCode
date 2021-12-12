package solutions;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException{
        
        Scanner inFile = new Scanner(new File("inputs/2.in"));
        
        // TASK 1
        
        String range;
        int rangeLow;
        int rangeHigh;
        String ch;
        char c;
        String pass;
        int numC;
        int numValid = 0;
        
        while(inFile.hasNext()) {
            numC = 0;
            range = inFile.next();
            Scanner sc = new Scanner(range);
            sc.useDelimiter("-");
            rangeLow = sc.nextInt();
            rangeHigh = sc.nextInt();
            
            ch = inFile.next();
            c = ch.charAt(0);
            
            pass = inFile.next();
            
            for(int i = 0; i < pass.length(); i++) {
                if (pass.charAt(i) == c) {
                    numC++;
                }
            }
            if(numC >= rangeLow && numC <= rangeHigh) {
                numValid++;
            }
            sc.close();
        }
        System.out.println("task 1: " + numValid);
        
        // TASK 2
        
        Scanner inFile2 = new Scanner(new File("inputs/2.in"));
        
        int numValid2 = 0;
        while(inFile2.hasNext()) {
            range = inFile2.next();
            Scanner sc = new Scanner(range);
            sc.useDelimiter("-");
            rangeLow = sc.nextInt();
            rangeHigh = sc.nextInt();
            
            ch = inFile2.next();
            c = ch.charAt(0);
            
            pass = inFile2.next();
            
            if(pass.charAt(rangeLow - 1) == c) {
                if (pass.charAt(rangeHigh - 1) != c) {
                    numValid2++;
                }
            }
            if(pass.charAt(rangeHigh - 1) == c) {
                if (pass.charAt(rangeLow - 1) != c) {
                    numValid2++;
                }
            }
            sc.close();
        }
        System.out.println("task 2: " + numValid2);
        inFile.close();
        inFile2.close();
    }
}