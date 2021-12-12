package solutions;

import java.util.*;
import java.io.*;

public class Day3 {
    
    public static long arrayToLong(int[] arr) {
        StringBuilder s = new StringBuilder(); 
        int n;
        for (int i = 0; i < arr.length; i++) {
            n = arr[i];
            s.append(n);
        }
    return Long.parseLong(s.toString()); 
    }
    
    public static void main(String[] args)  throws FileNotFoundException {
        
        Scanner inFile = new Scanner(new File("inputs/3.in"));
        
        // TASK 1
        
        int[] gamma = new int[12];
        int[] epsilon = new int[12];
        String[] arr = new String[1000];
        int num0;
        int num1;
        int i = 0;
        
        while(inFile.hasNext()) {
            arr[i] = inFile.next();
            i++;
        }
        
        for(int j = 0; j < 12; j++) {
            num0 = 0;
            num1 = 0;
            for(int k = 0; k < 1000; k++) {
                String binNum = arr[k];
                int bit = binNum.charAt(j) - '0';
                if(bit == 0) {
                    num0++;
                }
                else {
                    num1++;
                }
            }
            if(num0 < num1) {
                    gamma[j] = 0;
                    epsilon[j] = 1;
                }
                else {
                    gamma[j] = 1;
                    epsilon[j] = 0;
                }
        }
        long gammaInt = arrayToLong(gamma);
        long epsilonInt = arrayToLong(epsilon);
        epsilonInt = Long.parseLong(Long.toString(epsilonInt), 2);
        gammaInt = Long.parseLong(Long.toString(gammaInt), 2);
        System.out.println("task 1: " + epsilonInt * gammaInt);
        
        // TASK 2
        
        String[] OGR = new String[1000];
        System.arraycopy(arr, 0, OGR, 0, 1000);
        String[] Co2SR = new String[1000];
        System.arraycopy(arr, 0, Co2SR, 0, 1000);
        
        // for OGR
        for (int j = 0; j < 12; j++) {
            num0 = 0;
            num1 = 0;
            int n;
            for (int k = 0; k < 1000; k++) {
                String binNum = OGR[k];
                if (binNum.equals("")) {
                    break;
                }
                int bit = binNum.charAt(j) - '0';
                if (bit == 0) {
                    num0++;
                }
                else {
                    num1++;
                }
            }
            if (num0 > num1) {
                //keep all num0 in OGR
                n = 0;
                for (int l = 0; l < 1000; l++) {
                    String binNum2 = OGR[l];
                    if(OGR[l].equals("")) {
                        break;
                    }
                    int bit2 = binNum2.charAt(j) - '0';
                    if (bit2 == 0) {
                        OGR[n] = binNum2;
                        n++;
                    }
                }
                if(n != num0) {
                    System.out.println(n + " != " + num0);
                }
                for(int x = n; x < 1000; x++) {
                    if(n == 0) {
                        break;
                    }
                    OGR[x] = "";
                }
            }
            else {
                //keep all num1 in OGR
                n = 0;
                for (int l = 0; l < 1000; l++) {
                    String binNum2 = OGR[l];
                    if(OGR[l].equals("")) {
                        break;
                    }
                    int bit2 = binNum2.charAt(j) - '0';
                    if (bit2 == 1) {
                        OGR[n] = binNum2;
                        n++;
                    }  
                }
                if(n != num1) {
                    System.out.println(n + " != " + num1);
                }
                for(int x = n; x < 1000; x++) {
                    if(n == 0) {
                        break;
                    }
                    OGR[x] = "";
                }
            }
        }
        
        long finalOGR = Long.parseLong(OGR[0]);
        finalOGR = Long.parseLong(Long.toString(finalOGR), 2);
        
        // for Co2SR
        for (int j = 0; j < 12; j++) {
            num0 = 0;
            num1 = 0;
            int n;
            for (int k = 0; k < 1000; k++) {
                String binNum2 = Co2SR[k];
                if(Co2SR[k].equals("")) {
                    break;
                }
                int bit = binNum2.charAt(j) - '0';
                if(bit == 0) {
                    num0++;
                }
                else {
                    num1++;
                }
            }
            if (num1 < num0) {
                //keep all num1 in Co2SR
                n = 0;
                for (int l = 0; l < 1000; l++) {
                    String binNum2 = Co2SR[l];
                    if(Co2SR[l].equals("")) {
                        break;
                    }
                    int bit2 = binNum2.charAt(j) - '0';
                    if (bit2 == 1) {
                        Co2SR[n] = binNum2;
                        n++;
                    }
                }
                if(n != num1) {
                    System.out.println(n + " != " + num1);
                }
                for(int x = n; x < 1000; x++) {
                    if(n == 0) {
                        break;
                    }
                    Co2SR[x] = "";
                }
            }
            else {
                //keep all num0 in Co2SR
                n = 0;
                for (int l = 0; l < 1000; l++) {
                    String binNum2 = Co2SR[l];
                    if(Co2SR[l].equals("")) {
                        break;
                    }
                    int bit2 = binNum2.charAt(j) - '0';
                    if (bit2 == 0) {
                        Co2SR[n] = binNum2;
                        n++;
                    }  
                }
                if(n != num0) {
                    System.out.println(n + " != " + num0);
                }
                for(int x = n; x < 1000; x++) {
                    if(n == 0) {
                        break;
                    }
                    Co2SR[x] = "";
                }
            }
        }
        
        long finalCo2SR = Long.parseLong(Co2SR[0]);
        finalCo2SR = Long.parseLong(Long.toString(finalCo2SR), 2);
        
        System.out.println("task 2: " + finalOGR * finalCo2SR);
        inFile.close();
    }
}