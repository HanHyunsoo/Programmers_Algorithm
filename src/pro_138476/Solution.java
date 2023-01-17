package pro_138476;

import java.util.*;
import java.io.*;

public class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(tangerine)
                .forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));

        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((a, b) -> map.get(b) - map.get(a));

        for (int key : keys) {
            k -= map.get(key);
            answer++;
            if (k <= 0) {
                return answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3});
    }
}
