package Day4;

import java.io.*;
import java.util.*;

public class Day4 {
    
    public static int getIndexOfLargest( int[] array ) {
        if ( array == null || array.length == 0 ) return -1;

        int largest = 0;
        for ( int i = 1; i < array.length; i++ ) {
            if ( array[i] > array[largest] ) largest = i;
        }
        return largest;
       }
    
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner inFile = new Scanner(new File("years/2021/Day4/4.in"));
        int[] nums = {46,79,77,45,57,34,44,13,32,88,86,82,91,97,89,1,48,31,18,10,55,74,24,11,80,78,28,37,47,17,21,61,26,85,99,96,23,70,3,54,5,41,50,63,14,64,42,36,95,52,76,68,29,9,98,35,84,83,71,49,73,58,56,66,92,30,51,20,81,69,65,15,6,16,39,43,67,7,59,40,60,4,90,72,22,0,93,94,38,53,87,27,12,2,25,19,8,62,33,75};
        int[] drawn = new int[nums.length];
        
        // TASK 1
        
        int[][] board = new int[5][5];
        boolean winner = false;
       
        while (!winner) {
            
            for (int x = 0; x < nums.length; x++) {
                drawn[x] = nums[x];

                while(inFile.hasNext()) {
                    // scan in board
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            board[i][j] = inFile.nextInt();
                        }
                    }
                    // mark board with drawn numbers
                    for (int k = 0; k < nums.length; k++) {
                        if(drawn[k] == 0) {
                            break;
                        }
                        for(int l = 0; l < 5; l++) {
                            for (int m = 0; m < 5; m++) {
                                if (drawn[k] == board[l][m]) {
                                    board[l][m] = -1;
                                }
                            }
                        }
                    }
                    // check board for bingo
                    // rows
                    int sum;
                    for(int i = 0; i < 5; i++) {
                        if (winner == true) {
                            break;
                        }
                        sum = 0;
                        for (int j = 0; j < 5; j++) {
                            sum += board[i][j];
                        }
                        if (sum == -5) {
                            winner = true;
                            break;
                        }
                    }
                    // cols
                    for(int i = 0; i < 5; i++) {
                        if (winner == true) {
                            break;
                        }
                        sum = 0;
                        for (int j = 0; j < 5; j++) {
                            sum += board[j][i];
                        }
                        if (sum == -5) {
                            winner = true;
                            break;
                        }
                    }
                    // diagonal 1
                    sum = 0;
                    if (!winner) {
                        sum = board[0][0] + board[1][1] + board[2][2] + board[3][3] + board[4][4];
                        if (sum == -5) {
                            winner = true;
                        }
                    }
                    // diagonal 2
                    sum = 0;
                    if (!winner) {
                        sum = board[0][4] + board[1][3] + board[2][2] + board[3][1] + board[4][0];
                        if (sum == -5) {
                            winner = true;
                        }
                    }

                    if (winner == true) {
                        break;
                    }
                }
                if (!winner) {
                    inFile.close();
                    inFile = new Scanner(new File("years/2021/Day4/4.in"));
                }
                else {
                    break;
                }
            }
        }
        // calculate answer to task 1 with the winning board
        int lastNumCalled = 0;
        int finalSum = 0;
        for (int i = 0; i < drawn.length; i++) {
            if (drawn[i] == 0) {
                break;
            }
            lastNumCalled = drawn[i];
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] != -1) {
                    finalSum += board[i][j];
                }
            }
        }
        System.out.println("task 1: " + finalSum * lastNumCalled);
        
        // TASK 2
        
        int[][][] allBoards = new int[100][5][5];
        int[] numToSolve = new int[100];
        
        inFile.close();
        inFile = new Scanner(new File("years/2021/Day4/4.in"));
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    allBoards[i][j][k] = inFile.nextInt();
                }
            }
        }
        inFile.close();
    
        for (int i = 0; i < 100; i++) {
            winner = false;
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (nums[j] == allBoards[i][k][l]) {
                            allBoards[i][k][l] = -1;
                        }
                    }
                }
                // check board for bingo
                // rows
                int sum;
                for(int l = 0; l < 5; l++) {
                    if (winner == true) {
                        break;
                    }
                    sum = 0;
                    for (int m = 0; m < 5; m++) {
                        sum += allBoards[i][l][m];
                    }
                    if (sum == -5) {
                        winner = true;
                        break;
                    }
                }
                // cols
                for(int l = 0; l < 5; l++) {
                    if (winner == true) {
                        break;
                    }
                    sum = 0;
                    for (int m = 0; m < 5; m++) {
                        sum += allBoards[i][m][l];
                    }
                    if (sum == -5) {
                        winner = true;
                        break;
                    }
                }
                // diagonal 1
                sum = 0;
                if (!winner) {
                    sum = allBoards[i][0][0] + allBoards[i][1][1] + allBoards[i][2][2] + allBoards[i][3][3] + allBoards[i][4][4];
                    if (sum == -5) {
                        winner = true;
                    }
                }
                // diagonal 2
                sum = 0;
                if (!winner) {
                    sum = allBoards[i][0][4] + allBoards[i][1][3] + allBoards[i][2][2] + allBoards[i][3][1] + allBoards[i][4][0];
                    if (sum == -5) {
                        winner = true;
                    }
                }
                
                if (winner) {
                    numToSolve[i] = j;
                    break;
                }  
            }
        }
        
        int index = getIndexOfLargest(numToSolve);
        board = allBoards[index];
        
        lastNumCalled = nums[numToSolve[index]];
        finalSum = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] != -1) {
                    finalSum += board[i][j];
                }
            }
        }
        System.out.println("task 2: " + finalSum * lastNumCalled);
    }
}