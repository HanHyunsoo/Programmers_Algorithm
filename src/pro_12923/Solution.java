package pro_12923;

import java.util.Arrays;

public class Solution {
    public int getMaxDivisor(int n) {
        if (n == 1) return 0;

        int div = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                div = i;
                if (n / div <= 10000000) return n / div;
            }
        }

        return div;
    }

    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) + 1];

        int index = 0;

        for (int i = (int) begin; i <= end; i++) {
            answer[index++] = getMaxDivisor(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(100000014, 100000015)));
    }
}
