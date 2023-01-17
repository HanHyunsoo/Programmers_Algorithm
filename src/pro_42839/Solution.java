package pro_42839;

import java.util.*;

public class Solution {

    static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];

        int i = 0;
        for (char c : numbers.toCharArray()) {
            visited[i] = true;
            dfs(c + "", numbers, visited);
            visited[i] = false;
            i++;
        }

        return set.size();
    }

    public static void dfs(String value, String numbers, boolean[] visited) {
        int v = Integer.parseInt(value);

        if (isPrime(v)) {
            set.add(v);
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(value + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int value) {
        if (value <= 1) return false;

        for (int i = 2; i * i <= value; i++) {
            if (value % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        new Solution().solution("011");
    }
}
