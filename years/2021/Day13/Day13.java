package Day13;

import java.util.*;
import java.io.*;

public class Day13 {

    private static void printGrid(char[][] g, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(g[i][j]);
            }
            System.out.println();
        }
    }

    static char[] reverse(char[] a, int n) {
        char[] b = new char[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        return b;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("years/2021/Day13/13.in"));
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        while (file.hasNext()) {
            Scanner line = new Scanner(file.nextLine());
            line.useDelimiter(",");
            l1.add(line.nextInt());
            l2.add(line.nextInt());
        }
        int r = Collections.max(l1) + 1;
        int c = Collections.max(l2) + 1;
        char[][] grid = new char[r][c];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = ' ';
            }
        }
        file.close();

        file = new Scanner(new File("years/2021/Day13/13.in"));

        while (file.hasNext()) {
            Scanner line = new Scanner(file.nextLine());
            line.useDelimiter(",");
            grid[line.nextInt()][line.nextInt()] = '#';
        }

        //System.out.println("x = " + c + " y = " + r);

        // start folding
        file = new Scanner(new File("years/2021/Day13/13-2.in"));
        String inst;
        char[][] grid2;
        char[][] temp;
        int n = 0;
        int part1 = 0;
        while (file.hasNext()) {
            Scanner line = new Scanner(file.nextLine());
            line.useDelimiter("fold along ");
            inst = line.next();

            // vertical fold
            if (inst.charAt(0) == 'x') {
                int loc = Integer.parseInt(inst.substring(2));
                grid2 = new char[r][loc + 1];
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (j < loc) {
                            grid2[i][j] = grid[i][j];
                        }
                        else {
                            if (grid[i][j] == '#') {
                                grid2[i][loc - (j - loc)] = grid[i][j];
                            }
                        }
                    }
                }
                grid = new char[r][loc];
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < loc; j++) {
                        grid[i][j] = grid2[i][j];
                    }
                }
                c = loc;
            }
            // horizontal fold
            else {
                int loc = Integer.parseInt(inst.substring(2));
            
            }
            // for part 1
            if (n == 0) {
                part1 = 0;
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (grid[i][j] == '#') {
                            part1++;
                        }
                    }
                } 
            }
            n++;
        }
        file.close();

        //printGrid(grid, r, c);
        System.out.println(part1);
    }
}