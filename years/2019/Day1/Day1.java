package Day1;

import java.util.*;
import java.io.*;

class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner (new File("years/2019/Day1/1.in"));

        int num;
        int sum = 0;
        while (inFile.hasNext()) {
            num = inFile.nextInt();
            sum += (num / 3) - 2;
        }
        System.out.println(sum);
        inFile.close();

        inFile = new Scanner (new File("years/2019/Day1/1.in"));
        sum = 0;
        while (inFile.hasNext()) {
            num = inFile.nextInt();
            while (num > 0) {
                num = num / 3;
                num -= 2;
                if (num > 0) { 
                    sum += num; 
                }
            }
        }
        System.out.println(sum);
    }
}