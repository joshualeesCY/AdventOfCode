package Day11;

import java.util.*;
import java.io.*;

public class Day11 {
    
    private static int numFlashes;
    private static Deque<int[]> flashQ = new ArrayDeque<>();
    private static int[][] grid;
    private static int r;
    private static int c;
    
    public static void flash(int[] p) {
        int j = p[0];
        int k = p[1];
        int[] temp; 
        
        // flash north
        if (j != 0) {
            if (grid[j - 1][k] != 0 && grid[j - 1][k] <= 9) {
                grid[j - 1][k] += 1;
            }
            if (grid[j - 1][k] == 10) {
                temp = new int[2];
                temp[0] = p[0] - 1;
                temp[1] = p[1];
                grid[temp[0]][temp[1]] = 0;
                flashQ.push(temp);
            }
        }
        // south
        if (j != r - 1) {
            if (grid[j + 1][k] != 0 && grid[j + 1][k] <= 9) {
                grid[j + 1][k] += 1;
            }
            if (grid[j + 1][k] > 9) {
                temp = new int[2];
                temp[0] = p[0] + 1;
                temp[1] = p[1];
                grid[temp[0]][temp[1]] = 0;
                flashQ.push(temp);
            }
        }
        // east
        if (k != c - 1) {
            if (grid[j][k + 1] != 0 && grid[j][k + 1] <= 9) {
                grid[j][k + 1] += 1;
            }
            if (grid[j][k + 1] > 9) {
                temp = new int[2];
                temp[0] = p[0];
                temp[1] = p[1] + 1;
                grid[temp[0]][temp[1]] = 0;
                flashQ.push(temp);
            }
        }
        // west
        if (k != 0) {
            if (grid[j][k - 1] != 0 && grid[j][k - 1] <= 9) {
                grid[j][k - 1] += 1;
            }
            if (grid[j][k - 1] > 9) {
                temp = new int[2];
                temp[0] = p[0];
                temp[1] = p[1] - 1;
                grid[temp[0]][temp[1]] = 0;
                flashQ.push(temp);
            }
        } 
        // UL
        if (j != 0 && k != 0) {
            if (grid[j - 1][k - 1] != 0 && grid[j - 1][k - 1] <= 9) {
                grid[j - 1][k - 1] += 1;
            }
            if (grid[j - 1][k - 1] > 9) {
                temp = new int[2];
                temp[0] = p[0] - 1;
                temp[1] = p[1] - 1;
                grid[temp[0]][temp[1]] = 0;
                flashQ.push(temp);
            }
        }   
        // UR
        if (j != 0 && k != c - 1) {
            if (grid[j - 1][k + 1] != 0 && grid[j - 1][k + 1] <= 9) {
                grid[j - 1][k + 1] += 1;
            }
            if (grid[j - 1][k + 1] > 9) {
                temp = new int[2];
                temp[0] = p[0] - 1;
                temp[1] = p[1] + 1;
                grid[temp[0]][temp[1]] = 0;
                flashQ.push(temp);
            }
        }                          
        // LL
        if (j != r - 1 && k != 0) {
            if (grid[j + 1][k - 1] != 0 && grid[j + 1][k - 1] <= 9) {
                grid[j + 1][k - 1] += 1;
            }
            if (grid[j + 1][k - 1] > 9) {
                temp = new int[2];
                temp[0] = p[0] + 1;
                temp[1] = p[1] - 1;
                grid[temp[0]][temp[1]] = 0;
                flashQ.push(temp);
            }
        }   
        // LR
        if (j != r - 1 && k != c - 1) {
            if (grid[j + 1][k + 1] != 0 && grid[j + 1][k + 1] <= 9) {
                grid[j + 1][k + 1] += 1;
            }
            if (grid[j + 1][k + 1] > 9) {
                temp = new int[2];
                temp[0] = p[0] + 1;
                temp[1] = p[1] + 1;
                grid[temp[0]][temp[1]] = 0;
                flashQ.push(temp);
            }
        }
        numFlashes++;
    }
    
    public static void printGrid() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("11.in").getAbsolutePath());
        
        int[] point;
        final int STEPS = 100;
        
        String line;
        r = 0;
        c = 0;
        while (inFile.hasNext()) {
            line = inFile.nextLine();
            c = line.length();
            r++;
        }
        inFile.close();
        grid = new int[r][c];
        
        inFile = new Scanner(new File("11.in").getAbsolutePath());
        for (int i = 0; i < r; i++) {
            line = inFile.nextLine();
            for (int j = 0; j < c; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }
        inFile.close();

        numFlashes = 0;
        int n = 0;
        while (true) {
            n++;
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    grid[j][k] += 1;
                    // add to flash queue
                    if (grid[j][k] > 9) {
                        point = new int[2];
                        point[0] = j;
                        point[1] = k;
                        grid[j][k] = 0;
                        flashQ.push(point);
                    }
                }
            }
            
            while (!flashQ.isEmpty()) {
                flash(flashQ.pop());
            }
            
        // TASK 1
        
            if (n == STEPS) {
                System.out.println("task 1: " + numFlashes);
            }
            
        // TASK 2
        
            if (n > STEPS) {
                boolean zeros = true;
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        if (grid[j][k] != 0) {
                            zeros = false;
                        }
                    }
                }
                if (zeros) {
                    System.out.println("task 2: " + n);
                    break;
                }
            }
        }
    }
}