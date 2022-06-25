package pro_12909;

import java.util.Stack;

public class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("(())"));
        System.out.println(solution.solution(")("));
    }
}
