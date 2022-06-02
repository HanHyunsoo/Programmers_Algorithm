package pro_60057;

import java.util.Stack;

public class Solution {
    public static int solution(String s) {
        // answer의 최대값은 s의 길이이다.
        int answer = s.length();

        // 최소 두개의 문자열로 나눌 수 있기 때문에 s.length()의 반만큼 사이클 돌기
        for (int i = 0; i < s.length() / 2; i++) {
            Stack<String> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length() - i; j += 1 + i) {
                // 각 단계의 문자열
                String temp = s.substring(j, j + 1 + i);

                // 스택이 비어있지않고 스택 가장 위에있는 문자와 현재 단계의 문자가 일치하지 않으면
                if (!stack.isEmpty() && !stack.peek().equals(temp)) {
                    // 사이즈가 2이상이면 개수를 포함해서 sb에 문자열 연결
                    if (stack.size() != 1) {
                        sb.append(stack.size());
                    }
                    sb.append(stack.peek());
                    // 스택을 비운다.
                    stack.clear();
                }

                // 스택에 현재 단계 문자를 넣는다.
                stack.push(temp);
            }

            // 단계를 마치고 스택에 문자가 남아있으면
            if (!stack.isEmpty()) {
                // 사이즈가 2이상이면 개수를 포함해서 sb에 문자열 연결
                if (stack.size() != 1) {
                    sb.append(stack.size());
                }
                sb.append(stack.peek());
            }

            // i 단계가 나누어 떨어지지 않으면 뒤에 연결되지 않은 문자열을 연결한다.
            if (s.length() % (1 + i) != 0) {
                sb.append(s.substring(s.length() - s.length() % (1 + i)));
            }

            // 각 단계의 문자(sb)의 개수와 answer의 개수를 비교해서 최소값을 넣는다.
            answer = Math.min(answer, sb.length());

        }
        return answer;
    }

    public static void main(String[] args) {
        String test = "abcabcdede";

        System.out.println(solution(test));
    }
}
