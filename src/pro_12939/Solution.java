package pro_12939;

import java.util.Arrays;

public class Solution {
    public String solution(String s) {
        int[] numbers = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = numbers[0];
        int min = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            max = Math.max(max, numbers[i]);
            min = Math.min(min, numbers[i]);
        }

        return String.format("%d %d", min, max);
    }
}
