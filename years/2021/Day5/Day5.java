package solutions;

import java.util.*;
import java.io.*;

public class Day5 {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("inputs/5.in"));
        
        int x1;
        int x2;
        int y1;
        int y2;
        int[][] linesH_L = new int[500][4];
        int[][] linesH_R = new int[500][4];
        int[][] linesV_U = new int[500][4];
        int[][] linesV_D = new int[500][4];
        int[][] linesD_LR = new int[500][4];
        int[][] linesD_RL = new int[500][4];
        int[][] grid = new int[1000][1000];
        
        int numH_L = 0;
        int numH_R = 0;
        int numV_U = 0;
        int numV_D = 0;
        int numD_LR = 0;
        int numD_RL = 0;
        String s;
        while(inFile.hasNext()) {
            Scanner line = new Scanner(inFile.nextLine());
            // parsing logic
            line.useDelimiter(",");
            x1 = line.nextInt();
            line.useDelimiter(" ");
            s = line.next();
            s = s.replace(",", "");
            y1 = Integer.parseInt(s);
            line.next();
            line.useDelimiter(",");
            s = line.next();
            s = s.replace(" ", "");
            x2 = Integer.parseInt(s);
            s = line.next();
            s = s.replace(",", "");
            y2 = Integer.parseInt(s);

            line.close();
            
            // add to appropriate directional array
            if(x1 == x2) {
                if (y1 > y2) {
                    linesV_U[numV_U][0] = x1;
                    linesV_U[numV_U][1] = y1;
                    linesV_U[numV_U][2] = x2;
                    linesV_U[numV_U][3] = y2;
                    numV_U++;
                }
                else {
                    linesV_D[numV_D][0] = x1;
                    linesV_D[numV_D][1] = y1;
                    linesV_D[numV_D][2] = x2;
                    linesV_D[numV_D][3] = y2;
                    numV_D++;
                }
            }
            else if (y1 == y2) {
                if (x1 < x2) {
                    linesH_L[numH_L][0] = x1;
                    linesH_L[numH_L][1] = y1;
                    linesH_L[numH_L][2] = x2;
                    linesH_L[numH_L][3] = y2;
                    numH_L++;
                }
                else {
                    linesH_R[numH_R][0] = x1;
                    linesH_R[numH_R][1] = y1;
                    linesH_R[numH_R][2] = x2;
                    linesH_R[numH_R][3] = y2;
                    numH_R++;
                }
            }
            else if ((x2 - x1) == (y2 - y1)) {
                linesD_LR[numD_LR][0] = x1;
                linesD_LR[numD_LR][1] = y1;
                linesD_LR[numD_LR][2] = x2;
                linesD_LR[numD_LR][3] = y2;
                numD_LR++;
            }
            else if ((x2 - x1) == -(y2 - y1)) {
                linesD_RL[numD_RL][0] = x1;
                linesD_RL[numD_RL][1] = y1;
                linesD_RL[numD_RL][2] = x2;
                linesD_RL[numD_RL][3] = y2;
                numD_RL++;
            }
        }
        
        // TASK 1
        
        // add all horizontal and vertical lines to the grid
        int diff;
        int offset;
        // horizontal RIGHT
        for (int i = 0; i < numH_R; i++) {
            diff = linesH_R[i][2] - linesH_R[i][0];
            offset = linesH_R[i][0];
            for (int j = 0; j >= diff; j--) {
                grid[linesH_R[i][1]][j + offset]++;
            }
        }
        // horizontal LEFT
        for (int i = 0; i < numH_L; i++) {
            diff = linesH_L[i][2] - linesH_L[i][0];
            offset = linesH_L[i][0];
            for (int j = 0; j <= diff; j++) {
                grid[linesH_L[i][1]][j + offset]++;
            } 
        }
        // vertical UP
        for (int i = 0; i < numV_U; i++) {
            diff = linesV_U[i][3] - linesV_U[i][1];
            offset = linesV_U[i][1];
            for (int j = 0; j >= diff; j--) {
                grid[j + offset][linesV_U[i][0]]++;
            }     
        }
        // vertical DOWN
        for (int i = 0; i < numV_D; i++) {
            diff = linesV_D[i][3] - linesV_D[i][1];
            offset = linesV_D[i][1];
            for (int j = 0; j <= diff; j++) {
                grid[j + offset][linesV_D[i][0]]++;
            }
        }
        
        // check grid for intersections (TASK 1)
        int numIntersect = 0;
        for(int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if(grid[i][j] >= 2) {
                    numIntersect++;
                }
            }
        }
        System.out.println("task 1: " + numIntersect);
        
        // TASK 2
        
        // add all diagonal lines to grid
        int offset2;
        // Diagonal LR
        for (int i = 0; i < numD_LR; i++ ) {
            diff = linesD_LR[i][3] - linesD_LR[i][1];
            offset = linesD_LR[i][0];
            offset2 = linesD_LR[i][1];
            if (diff < 0) {
                for (int j = 0; j >= diff; j--) {
                    grid[j + offset2][j + offset]++;
                }
            }
            else {
                for (int j = 0; j <= diff; j++) {
                    grid[j + offset2][j + offset]++;
                }
            }
        }
        // Diagonal RL
        for (int i = 0; i < numD_RL; i++) {
            diff = linesD_RL[i][1] - linesD_RL[i][3];
            offset = linesD_RL[i][0];
            offset2 = linesD_RL[i][1];
            if (diff < 0) {
                diff *= -1;
                for (int j = 0; j <= diff; j++) {
                    grid[j + offset2][-j + offset]++;
                }
            }
            else {
                for (int j = 0; j <= diff; j++) {
                    grid[-j + offset2][j + offset]++;
                }
            }
        }
        
        numIntersect = 0;
        for(int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if(grid[i][j] >= 2) {
                    numIntersect++;
                }
            }
        }
        System.out.println("task 2: " + numIntersect);
        inFile.close();
    }
}