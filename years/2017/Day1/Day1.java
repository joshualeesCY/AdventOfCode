package Day1;

import java.util.*;
import java.io.*;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("years/2017/Day1/1.in"));
        String nums = inFile.nextLine();
        inFile.close();
        int halfWay = nums.length() / 2;
        int num;
        int numNext;
        int numNext2;
        int sum = 0;
        int sum2 = 0;
        
        for (int i = 0; i < nums.length(); i++) {
            num = nums.charAt(i) - '0';
            numNext = nums.charAt((i + 1) % nums.length()) - '0';
            numNext2 = nums.charAt((i + halfWay) % nums.length()) - '0';
            if (num == numNext) {
                sum += num;
            }
            if (num == numNext2) {
                sum2 += num;
            }
        }
        System.out.println(sum);
        System.out.println(sum2);
    }
}