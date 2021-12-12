package solutions;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner inFile = new Scanner(new File("inputs/3.in"));
        
        // TASK 1
        
        final int ROW = 323;
        final int COL = 31;
        String line;
        int i = 0;
        char[][] grid = new char[ROW][COL];
        while (inFile.hasNext()) {
            line = inFile.next();
            for (int j = 0; j < 31; j++) {
                grid[i][j] = line.charAt(j);
            }
            i++;
        }
        
        int currCol = 0;
        int currRow = 0;
        int numTrees = 0;
        
        while(currRow < 323) {
            if (grid[currRow][currCol] == '#') {
                numTrees++;
            }
            currCol = (currCol + 3) % COL;
            currRow++;
        }
        System.out.println("task 1: " + numTrees);
        
        // TASK 2
        
        int ruleOne = 0;
        int ruleTwo = 0;
        int ruleThree = 0;
        int ruleFour = 0;
        int ruleFive = 0;
        
        // rule one: right 1 down 1
        currCol = 0;
        currRow = 0;
        while(currRow < 323) {
            if (grid[currRow][currCol] == '#') {
                ruleOne++;
            }
            currCol = (currCol + 1) % COL;
            currRow++;
        }
        // rule two: right 3 down 1
        currCol = 0;
        currRow = 0;
        while(currRow < 323) {
            if (grid[currRow][currCol] == '#') {
                ruleTwo++;
            }
            currCol = (currCol + 3) % COL;
            currRow++;
        }
        // rule three: right 5 down 1
        currCol = 0;
        currRow = 0;
        while(currRow < 323) {
            if (grid[currRow][currCol] == '#') {
                ruleThree++;
            }
            currCol = (currCol + 5) % COL;
            currRow++;
        }
        // rule four: right 7 down 1
        currCol = 0;
        currRow = 0;
        while(currRow < 323) {
            if (grid[currRow][currCol] == '#') {
                ruleFour++;
            }
            currCol = (currCol + 7) % COL;
            currRow++;
        }
        // rule five: right 1 down 2
        currCol = 0;
        currRow = 0;
        while(currRow < 323) {
            if (grid[currRow][currCol] == '#') {
                ruleFive++;
            }
            currCol = (currCol + 1) % COL;
            currRow += 2;
        }
        long ans = ruleOne * ruleTwo;
        ans *= ruleThree;
        ans *= ruleFour;
        ans *= ruleFive;
        System.out.println("task 2: " + ans);
        inFile.close();
    }
}