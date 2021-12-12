package Day2;

import java.util.*;
import java.io.*;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        String s;
        int horizontal = 0;
        int depth = 0;
        
        Scanner inFile = new Scanner(new File("years/2021/Day2/2.in"));
        
        // TASK 1
        
        while(inFile.hasNext()) {
            s = inFile.next();
            switch (s) {
                case "forward":
                    horizontal += inFile.nextInt();
                    break;
                case "down":
                    depth += inFile.nextInt();
                    break;
                case "up":
                    depth -= inFile.nextInt();
                    break;
                default:
                    break;
            }
        }
        System.out.println("task 1: " + horizontal * depth);
        inFile.close();
        // TASK 2
        
        Scanner inFile2 = new Scanner(new File("years/2021/Day2/2.in"));
        horizontal = 0;
        depth = 0;
        int aim = 0;
        int next;
        
        while(inFile2.hasNext()) {
            s = inFile2.next();
            next = inFile2.nextInt();
            switch (s) {
                case "forward":
                    horizontal += next;
                    depth += aim * next;
                    break;
                case "down":
                    aim += next;
                    break;
                case "up":
                    aim -= next;
                    break;
                default:
                    break;
            }
        }
        System.out.println("task 2: " + horizontal * depth);
        inFile2.close();
    }
}
