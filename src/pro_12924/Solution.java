package pro_12924;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum == n) answer++;
                else if (sum > n) break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(15));
    }
}
