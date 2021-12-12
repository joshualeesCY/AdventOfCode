package Day1;

import java.util.*;
import java.io.*;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("years/2018/Day1/1.in"));
        ArrayList<Integer> seen = new ArrayList<>();
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
            if (!seen.isEmpty()) {
                for (int i = 0; i < seen.size(); i++) {
                    if (sum == seen.get(i)) {
                        twice.add(sum);
                    }
                }
            }
            seen.add(sum);
        }
        System.out.println(sum);
        System.out.println(twice);
    }
}
