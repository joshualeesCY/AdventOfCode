package Day1;

import java.util.*;
import java.io.*;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("years/2018/Day1/1.in"));
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> twice = new ArrayList<>();

        String line;
        int sum = 0;
        int n = 0;
        while (inFile.hasNext()) {
            line = inFile.nextLine();
            if (line.charAt(0) == '+') {
                sum += Integer.parseInt(line.substring(1, line.length()));
            }
            else {
                sum -= Integer.parseInt(line.substring(1, line.length()));
            }
            if (!nums.isEmpty()) {
                for (int i = 0; i < nums.size(); i++) {
                    if (sum == nums.get(i)) {
                        twice.add(sum);
                    }
                }
            }
            nums.add(sum);
        }
        System.out.println(sum);
        System.out.println(twice.size());
    }
}
