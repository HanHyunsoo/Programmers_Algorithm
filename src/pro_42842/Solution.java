package pro_42842;

import java.util.*;

class Solution {
    public List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);

                if (n / i != i) {
                    divisors.add(n / i);
                }
            }
        }

        return divisors;
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = {-1, -1};

        List<Integer> divisors = getDivisors(yellow);

        for (Integer divisor : divisors) {
            int x = divisor;
            int y = yellow / divisor;

            if (x * 2 + y * 2 + 4 == brown) {
                answer[0] = x + 2;
                answer[1] = y + 2;
                break;
            }
        }

        if (answer[0] < answer[1]) {
            int temp = answer[1];

            answer[1] = answer[0];
            answer[0] = temp;
        }

        return answer;
    }
}