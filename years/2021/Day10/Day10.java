package Day10;

import java.util.*;
import java.io.*;

public class Day10 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new FileReader("years/2021/Day10/10.in"));
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Character> chs = new ArrayList<>();
        ArrayList<String> theRest = new ArrayList<>();
       
        int numLines = 0;
        while (inFile.hasNext()) {
            lines.add(inFile.nextLine());
            numLines++;
        }
        inFile.close();
        
        Deque<Character> chars = new ArrayDeque<>();
        String line;
        boolean mismatch = false;
        char c;
        char ch;
        for (int i = 0; i < numLines; i++) {
            line = lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                mismatch = false;
                ch = line.charAt(j);
                switch (ch) {
                    // ()
                    case '(': 
                        chars.push('('); 
                        break;
                    case ')': 
                        c = chars.pop();
                        if (c != '(') {
                            mismatch = true;
                            chs.add(ch);
                        }
                        break;
                    // []
                    case '[': 
                        chars.push('['); 
                        break;
                    case ']': 
                        c = chars.pop();
                        if (c != '[') {
                            mismatch = true;
                            chs.add(ch);
                        }
                        break;
                    // {}
                    case '{': 
                        chars.push('{'); 
                        break;
                    case '}': 
                        c = chars.pop();
                        if (c != '{') {
                            mismatch = true;
                            chs.add(ch);
                        }
                        break;
                    // <>
                    case '<': 
                        chars.push('<'); 
                        break;
                    case '>': 
                        c = chars.pop();
                        if (c != '<') {
                            mismatch = true;
                            chs.add(ch);
                        }
                        break;
                    default:
                        break;
                }
                if (mismatch) {
                    break;
                }
            }
            if (!chars.isEmpty() && !mismatch) {
                String rest = "";
                int num = chars.size();
                for (int j = 0; j < num; j++) {
                    rest += chars.pop();
                }
                theRest.add(rest);
            }
            chars.clear();
        }
        
        // TASK 1
        
        int points = 0;
        for (int i = 0; i < chs.size(); i++) {
            switch (chs.get(i)) {
                case ')':
                    points += 3;
                    break;
                case ']':
                    points += 57;
                    break;
                case '}':
                    points += 1197;
                    break;
                case '>':
                    points += 25137;
                    break;
                default:
                    break;
            }
        }
        System.out.println("task 1: " + points);
        
        // TASK 2
        
        long[] scores = new long[theRest.size()];
        for (int i = 0; i < theRest.size(); i++) {
            line = theRest.get(i);
            long point = 0;
            for (int j = 0; j < line.length(); j++) {
                ch = line.charAt(j);
                switch (ch) {
                    case '(':
                        point *= 5;
                        point += 1;
                        break;
                    case '[':
                        point *= 5;
                        point += 2;
                        break;
                    case '{':
                        point *= 5;
                        point += 3;
                        break;
                    case '<':
                        point *= 5;
                        point += 4;
                        break;
                    default:
                        break;
                }
            }
            scores[i] = point;
        }
        Arrays.sort(scores);
        int middle = (scores.length / 2);
        System.out.println("task 2: " + scores[middle]);
    }
}