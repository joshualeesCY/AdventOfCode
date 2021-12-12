package Day1;

import java.io.*;
import java.util.*;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("years/2016/Day1/1.in"));
        inFile.useDelimiter(", ");
        ArrayList<String> data = new ArrayList<>();
        // 0 is north, 1 is east, 2 is south, 3 is west;
        int direction = 0;
        int north = 0;
        int south = 0;
        int east = 0;
        int west = 0;

        while (inFile.hasNext()) {
            data.add(inFile.next());
        }

        for (String step : data) {
            char LR = step.charAt(0);
            int dist = Integer.parseInt(step.substring(1, step.length()));

            if (LR == 'L') {
                switch (direction) {
                    case 0:
                        direction = 3;
                        west += dist;
                        break;
                    case 1:
                        direction = 0;
                        north += dist;
                        break;
                    case 2:
                        direction = 1;
                        east += dist;
                        break;
                    case 3:
                        direction = 2;
                        south += dist;
                        break;
                    default:
                        break;
                }
            }
            else {
                switch (direction) {
                    case 0:
                        direction = 1;
                        east += dist;
                        break;
                    case 1:
                        direction = 2;
                        south += dist;
                        break;
                    case 2:
                        direction = 3;
                        west += dist;
                        break;
                    case 3:
                        direction = 0;
                        north += dist;
                        break;
                    default:
                        break;
                }
            }
        }
        int vert;
            int horiz;
            if (north > south) {
                vert = north - south;
            }
            else {
                vert = south - north;
            }
            if (east > west) {
                horiz = east - west;
            }
            else {
                horiz = west - east;
            }
            System.out.println(vert + horiz);
    }
}