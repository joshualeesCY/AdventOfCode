package Day1;

import java.io.*;
import java.util.*;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("years/2015/Day1/1.in"));
        String data = inFile.nextLine();
        ArrayList<Integer> pos = new ArrayList<>();
        int floor = 0;
        for (int i = 0; i < data.length(); i++) {
            switch (data.charAt(i)) {
                case '(':
                    floor++;
                    break;
                case ')':
                    floor--;
                    break;
                default:
                    break;
            }
            if (floor < 0) {
                pos.add(i+1);
            }
        }
        System.out.println(floor);
        System.out.println(pos.get(0));
    }
}