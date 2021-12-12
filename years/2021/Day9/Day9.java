package solutions;

import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
import solutions.queue.*;

public class Day9 {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("inputs/9.in"));
        
        
        int r = 0;
        int c = 0;
        String ln = "";
        while(inFile.hasNext()) {
            ln = inFile.nextLine();
            c = ln.length();
            r++;
        }
        int[][] grid = new int[r][c];
        inFile.close();
        
        inFile = new Scanner(new File("inputs/9.in"));
        
        String l = "";
        for(int i =0; i < r; i++) {
            l = inFile.next();
            for (int j = 0; j < c; j++) {
                grid[i][j] = l.charAt(j) - '0';
            }
        }
        inFile.close();
        
        // TASK 1
        
        // for each point on grid, check directions, 
        // if its less than all of them, add it plus
        // one to the total sum
        // mark it with a -1 and save it in array for task 2
        
        boolean bigNorth;
        boolean bigSouth;
        boolean bigEast;
        boolean bigWest;
        int sum = 0;
        int numLow = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                bigNorth = false;
                bigSouth = false;
                bigEast = false;
                bigWest = false;
                
                // check north
                if (i == 0) {
                    bigNorth = true;
                }
                else if (grid[i - 1][j] > grid[i][j]) {
                    bigNorth = true;
                }
                // south
                if (i == r - 1) {
                    bigSouth = true;
                }
                else if (grid[i + 1][j] > grid[i][j]) {
                    bigSouth = true;
                }
                // east
                if (j == c - 1) {
                    bigEast = true;
                }
                else if (grid[i][j + 1] > grid[i][j]) {
                    bigEast = true;
                }
                // west
                if (j == 0) {
                    bigWest = true;
                }
                else if (grid[i][j - 1] > grid[i][j]) {
                    bigWest = true;
                }
                
                if (bigNorth && bigSouth && bigEast && bigWest) {
                    sum += grid[i][j] + 1;
                    grid[i][j] = - 1;
                    numLow++;
                }
            }
        }
        System.out.println("task 1: " + sum);
        
        // TASK 2
        
        // store locations of low points
        int[][] low = new int[numLow][2];
        numLow = 0;
        for(int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == -1) {
                    low[numLow][0] = i;
                    low[numLow][1] = j;
                    numLow++;
                }
            }
        }
        // bfs each low point, calculating size along the way
        Queue<int[]> q = new Queue<>();
        int[] sizes = new int[numLow];
        int troughSize;
        int[] now;
        int[] temp;
        for(int i = 0; i < low.length; i++) {
            q.enqueue(low[i]);
            troughSize = 1;
            while(!q.isEmpty()) {
                now = q.dequeue();
                // check north
                if (now[0] != 0) {
                    if (grid[now[0] - 1][now[1]] != 9 && grid[now[0] - 1][now[1]] != -1) {
                        temp = new int[2];
                        temp[0] = now[0] - 1;
                        temp[1] = now[1];
                        grid[temp[0]][temp[1]] = -1;
                        q.enqueue(temp);
                        troughSize++;
                    }
                }
                // check south
                if (now[0] != r - 1) {
                    if (grid[now[0] + 1][now[1]] != 9 && grid[now[0] + 1][now[1]] != -1) {
                        temp = new int[2];
                        temp[0] = now[0] + 1;
                        temp[1] = now[1];
                        grid[temp[0]][temp[1]] = -1;
                        q.enqueue(temp);
                        troughSize++;
                    }
                }
                // check east
                if (now[1] != c - 1) {
                    if (grid[now[0]][now[1] + 1] != 9 && grid[now[0]][now[1] + 1] != -1) {
                        temp = new int[2];
                        temp[0] = now[0];
                        temp[1] = now[1] + 1;
                        grid[temp[0]][temp[1]] = -1;
                        q.enqueue(temp);
                        troughSize++;
                    }
                }
                // check west
                if (now[1] != 0) {
                    if (grid[now[0]][now[1] - 1] != 9 && grid[now[0]][now[1] - 1] != -1) {
                        temp = new int[2];
                        temp[0] = now[0];
                        temp[1] = now[1] - 1;
                        grid[temp[0]][temp[1]] = -1;
                        q.enqueue(temp);
                        troughSize++;
                    }
                }
            }
            sizes[i] = troughSize;
        }
        Arrays.sort(sizes);
        sum = sizes[sizes.length - 1] * sizes[sizes.length - 2] * sizes[sizes.length - 3];
        System.out.println("task 2: " + sum);
    }
}