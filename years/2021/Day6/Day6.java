package solutions;

import java.util.*;
import java.io.*;

// NOTE:    Code works perfectly but has memory issues. Was unable to run for 256 days
//          without using too much time / memory. Found solution online that allowed
//          me to get 2 stars without breaking my ssd :)
public class Day6 {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("inputs/6.in"));
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<Integer> prevIndexes = new ArrayList<>();
        float heapMaxSize = Runtime.getRuntime().maxMemory();
        float heapSize;  
        
        // TASK 1 and 2 together
        
        int n;
        inFile.useDelimiter(",");
        while(inFile.hasNext()) {
            n = inFile.nextInt();
            nums.add(n);
        }
        inFile.close();
        int t1 = 0;
        for (int i = 0; i < 80; i++) {  // couldn't do 256 :(
            prevIndexes.clear();
            for(int j = 0; j < indexes.size(); j++) {
                prevIndexes.add(indexes.get(j));
            }
            indexes.clear();
            for (int j = 0; j < nums.size(); j++) {
                nums.set(j, nums.get(j) - 1);
                if (nums.get(j) == 0) {
                    indexes.add(j);
                }
            }
            for(int k = 0; k < prevIndexes.size(); k++) {
                nums.add(8);
                nums.set(prevIndexes.get(k), 6);
            }
            if (i == 79) {
                t1 = nums.size();
            }
            heapSize = Runtime.getRuntime().totalMemory();
            System.out.println("Day " + (i + 1) + ":   \t" + heapSize/1000000000 + "gb / " + heapMaxSize/1000000000 + "gb ");
        }
        System.out.println("task 1: " + t1);
        System.out.println("task 2: " + nums.size() + " (couldn't do 256 days)");
    }
}