package Day22;

import java.util.*;
import java.io.*;

public class Day22 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner (new File("years/2021/Day22/22.in"));
        List<String> on = new ArrayList<>();
        List<String> off = new ArrayList<>();
        int n;
        int r;
        int c;
        
        String line;
        while (file.hasNext()) {
            line = file.nextLine();
            if(line.substring(0,3).equals("off")) {
                off.add(line);
            }
            else {
                on.add(line);
            }
        }
    }
}
