package Day15;

import java.io.*;
import java.util.*;

public class Day15 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("years/2021/Day15/15.in"));

        int r = 0;
        int c = 0;
        String line;
        while (file.hasNext()) {
            line = file.nextLine();
            c = line.length();
            r++;
        }
        file.close();

        file = new Scanner(new File("years/2021/Day15/15.in"));
        int[][] nums = new int[r][c];
        int[][] visited = new int[r][c];


        int n = 0;
        while (file.hasNext()) {
            line = file.nextLine();
            for (int i = 0; i < line.length(); i++) {
                nums[n][i] = line.charAt(i) - '0';
            }
            n++;
        }

        int[] start = {0,0};
        int[] end = {r - 1, c - 1};

    }
}