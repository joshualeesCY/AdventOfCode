package Day2;

import java.util.*;
import java.io.*;

class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("years/2019/Day2/2.in"));
        List<Integer> nums = new ArrayList<>();
        List<Integer> origNums = new ArrayList<>();

        file.useDelimiter(",");
        while (file.hasNext()) {
            int n = file.nextInt();
            nums.add(n);
            origNums.add(n);
        }

        int posVal = 0;
        int pos = 0;
        nums.set(1, 12);
        nums.set(2, 2);
        while (posVal != 99) {
            switch (nums.get(pos)) {
                case 1:
                    posVal = nums.get(pos);
                    nums.set(nums.get(pos + 3), nums.get(nums.get(pos + 1)) + nums.get(nums.get(pos + 2)));
                    break;
                case 2:
                    posVal = nums.get(pos);
                    nums.set(nums.get(pos + 3), nums.get(nums.get(pos + 1)) * nums.get(nums.get(pos + 2)));
                    break;
                case 99:
                    posVal = nums.get(pos);
                    break;
                default:
                    break;
            }
            pos += 4;
        }
        System.out.println(nums.get(0));
        nums.clear();
        nums.addAll(origNums);

        int noun;
        int verb;
        for (noun = 0; noun < 100; noun++) {
            for (verb = 0; verb < 100; verb++) {
                nums.clear();
                nums.addAll(origNums);
                nums.set(1, noun);
                nums.set(2, verb);
                posVal = 0;
                pos = 0;
                while (posVal != 99) {
                    switch (nums.get(pos)) {
                        case 1:
                            posVal = nums.get(pos);
                            nums.set(nums.get(pos + 3), nums.get(nums.get(pos + 1)) + nums.get(nums.get(pos + 2)));
                            break;
                        case 2:
                            posVal = nums.get(pos);
                            nums.set(nums.get(pos + 3), nums.get(nums.get(pos + 1)) * nums.get(nums.get(pos + 2)));
                            break;
                        case 99:
                            posVal = nums.get(pos);
                            break;
                        default:
                            break;
                    }
                    pos += 4;
                }
                if (nums.get(0) == 19690720) {
                    System.out.println((100 * noun) + verb);
                    break;
                }
            }
        }
    }
}