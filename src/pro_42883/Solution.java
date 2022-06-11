package pro_42883;

import java.util.Stack;

public class Solution {
    public static String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            int temp = number.charAt(i) - '0';

            while (!stack.isEmpty() && k != 0) {
                if (stack.peek() < temp) {
                    stack.pop();
                    k--;
                } else {
                    break;
                }
            }
            stack.push(temp);
        }

        if (k != 0) {
            for (int i = 0; i < k; i++) {
                stack.pop();
            }
        }

        StringBuilder result = new StringBuilder();
        stack.forEach(result::append);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("654321", 5));
    }
}
