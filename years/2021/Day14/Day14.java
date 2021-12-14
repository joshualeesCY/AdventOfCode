package Day14;

import java.io.*;
import java.util.*;

public class Day14 {

    private static String addChar(String str, char ch, int position) {
        return str.substring(0, position) + ch + str.substring(position);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("years/2021/Day14/14.in"));
        String seq = "CPSSSFCFOFVFNVPKBFVN";
        List<Character> chars = new ArrayList<>();
        List<String> rules = new ArrayList<>();

        while(file.hasNext()) {
            rules.add(file.nextLine());
        }
        

        for (int n = 0; n < 15; n++) {
            int i = 0;
            while (i < seq.length() - 1) {
                String pair = seq.substring(i, i+2);
                for (int j = 0; j < rules.size(); j++) {
                    if (pair.equals(rules.get(j).substring(0,2))) {
                        seq = addChar(seq, rules.get(j).charAt(6), i+1);
                        i+=1;
                    }
                }
                i++;
            }
            if (n == 9) {
                boolean seen = false;
                for (int j = 0; j < seq.length(); j++) {
                    char ch = seq.charAt(j);
                    seen = false;
                    for (int k = 0; k < chars.size(); k++) {
                        if (ch == chars.get(k)) {
                            seen = true;
                        }
                    }
                    if(!seen) {
                        chars.add(ch);
                    }
                }

                List<Long> nums = new ArrayList<>();
                for (int j = 0; j < chars.size(); j++) {
                    long n1 = 0;
                    for (int k = 0; k < seq.length(); k++) {
                        if (chars.get(j) == seq.charAt(k)) {
                            n1++;
                        }
                    }
                    nums.add(n1);
                }
                long max = Collections.max(nums);
                long min = Collections.min(nums);
                System.out.println(max - min);
            }
            System.out.println(n);
        }

        boolean seen = false;
        for (int i = 0; i < seq.length(); i++) {
            char ch = seq.charAt(i);
            seen = false;
            for (int j = 0; j < chars.size(); j++) {
                if (ch == chars.get(j)) {
                    seen = true;
                }
            }
            if(!seen) {
                chars.add(ch);
            }
        }

        List<Long> nums = new ArrayList<>();
        for (int i = 0; i < chars.size(); i++) {
            long n = 0;
            for (int j = 0; j < seq.length(); j++) {
                if (chars.get(i) == seq.charAt(j)) {
                    n++;
                }
            }
            nums.add(n);
        }
        long max = Collections.max(nums);
        long min = Collections.min(nums);
        System.out.println(max - min);
    }
}