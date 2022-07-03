package pro_68644;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        new Solution().solution(new int[]{2,1,3,4,1});
    }
}
