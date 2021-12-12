package Day8;

import java.util.*;
import java.io.*;

public class Day8 {
    
    public static String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("years/2021/Day8/8.in"));
        String[][] out = new String[200][4];
        String[][] in = new String[200][10];
        
        // TASK 1
        
        int n = 0;
        String s;
        while(inFile.hasNext()) {
            for (int i = 0; i < 10; i++) {
                s = sortString(inFile.next());
                in[n][i] = s;
            }
            inFile.next();
            out[n][0] = sortString(inFile.next());
            out[n][1] = sortString(inFile.next());
            out[n][2] = sortString(inFile.next());
            out[n][3] = sortString(inFile.next());
            n++;
        }
        
        int sum = 0;
        for(int i = 0; i < 200; i++) {
            for (int j = 0; j < 4; j++) {
                if (out[i][j].length() == 2 || out[i][j].length() == 3 || out[i][j].length() == 4 || out[i][j].length() == 7) {
                    sum++;
                }
            }
        }
        System.out.println("task 1: " + sum);
        
        // TASK 2;
        
        String zero = "";
        String one = "";
        String two = "";
        String three = "";
        String four = "";
        String five = "";
        String six = "";
        String seven = "";
        String eight = "";
        String nine = "";
        sum = 0;
        String sSum = "";
        // find 1, 4, 7, and 8
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 10; j++) {
                switch (in[i][j].length()) {
                    case 2:
                        one = in[i][j];
                        break;
                    case 3:
                        seven = in[i][j];
                        break;
                    case 4:
                        four = in[i][j];
                        break;
                    case 7:
                        eight = in[i][j];
                        break;
                    default:
                        break;
                }
            }
            
            // find 9
            for (int j = 0; j < 10; j++) {
                if (in[i][j].length() == 6) {
                    if (in[i][j].indexOf(four.charAt(0)) != -1 && in[i][j].indexOf(four.charAt(1)) != -1 && in[i][j].indexOf(four.charAt(2)) != -1 && in[i][j].indexOf(four.charAt(3)) != -1) {
                        nine = in[i][j];
                        break;
                    }
                }
            }
            
            // find the right bottom character
            String leftBottom = eight;
            for (int j = 0; j < nine.length(); j++) {
                leftBottom = leftBottom.replace(String.valueOf(nine.charAt(j)), "");
            }
            
            // find 2
            for (int j = 0; j < 10; j++) {
                if (in[i][j].length() == 5) {
                    if (in[i][j].contains(leftBottom)) {
                        two = in[i][j];
                        break;
                    }
                }
            }
            // find 5
            for (int j = 0; j < 10; j++) {
                if (in[i][j].length() == 5) {
                    if (!in[i][j].contains(leftBottom) && !in[i][j].equals(three)) {
                        five = in[i][j];
                        break;
                    }
                }
            }
            // find 3
            for (int j = 0; j < 10; j++) {
                if (in[i][j].length() == 5) {
                    if (!in[i][j].equals(two) && !in[i][j].equals(five)) {
                        three = in[i][j];
                        break;
                    }
                }
            }
            // find 0
            for (int j = 0; j < 10; j++) {
                if (in[i][j].length() == 6) {
                    if (in[i][j].contains(leftBottom) && in[i][j].indexOf(seven.charAt(0)) != -1 && in[i][j].indexOf(seven.charAt(1)) != -1 && in[i][j].indexOf(seven.charAt(2)) != -1) {
                        zero = in[i][j];
                        break;
                    }
                }
            }
            // find 6
            for (int j = 0; j < 10; j++) {
                if (in[i][j].length() == 6) {
                    if (in[i][j].contains(leftBottom) && !in[i][j].equals(zero)) {
                        six = in[i][j];
                        break;
                    }
                }
            }
            
            sSum = "";
            for (int j = 0; j < 4; j++) {
                if (out[i][j].equals(zero)) {
                    sSum += "0";
                }
                else if (out[i][j].equals(one)) {
                    sSum += "1";
                }
                else if (out[i][j].equals(two)) {
                    sSum += "2";
                }
                else if (out[i][j].equals(three)) {
                    sSum += "3";
                }
                else if (out[i][j].equals(four)) {
                    sSum += "4";
                }
                else if (out[i][j].equals(five)) {
                    sSum += "5";
                }
                else if (out[i][j].equals(six)) {
                    sSum += "6";
                }
                else if (out[i][j].equals(seven)) {
                    sSum += "7";
                }
                else if (out[i][j].equals(eight)) {
                    sSum += "8";
                }
                else if (out[i][j].equals(nine)) {
                    sSum += "9";
                }
            }
            sum += Integer.parseInt(sSum);
        }
        System.out.println("task 2: " + (sum - 160)); // temporary fix (come back)
        inFile.close();
    }
}