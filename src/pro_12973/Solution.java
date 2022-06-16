package pro_12973;

import java.util.Stack;

public class Solution {
    public static int solution(String s)
    {
        if (s.length() % 2 == 1) return 0;

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("cbcb"));
    }
}
