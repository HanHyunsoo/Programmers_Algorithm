package pro_42746;

import java.util.Arrays;

public class Solution {
    public String solution(int[] numbers) {
        String[] stringNumbers = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        Arrays.sort(stringNumbers, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        String answer = Arrays.stream(stringNumbers).reduce("", (total, s) -> total + s);

        return (answer.charAt(0) == '0') ? "0" : answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{0, 0, 0, 0}));
    }
}
