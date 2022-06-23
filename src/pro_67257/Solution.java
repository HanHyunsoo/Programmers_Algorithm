package pro_67257;

import java.util.*;

public class Solution {
    static char[][] signCases = {{'*', '-', '+'}, {'*', '+', '-'}, {'+', '*', '-'}, {'+', '-', '*'}, {'-', '*', '+'}, {'-', '+', '*'}};
    static List<Object> expressionList = new LinkedList<>();
    static long answer = 0;

    public static long solution(String expression) {
        expression += " ";
        StringBuilder temp = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                temp.append(c);
            } else {
                expressionList.add(Long.parseLong(temp.toString()));
                temp = new StringBuilder();

                if (c != ' ') expressionList.add(c);
            }
        }

        for (char[] signCase : signCases) {
            Queue<Object> queue = new LinkedList<>(expressionList);
            Deque<Object> deque = new ArrayDeque<>();
            for (char sign : signCase) {
                while (!queue.isEmpty()) {
                    Object value = queue.poll();

                    if (value instanceof Character && (Character) value == sign) {
                        Long popValue = (Long) deque.removeLast();
                        deque.addLast(calculation(popValue, (Long) queue.poll(), sign));
                        continue;
                    }

                    deque.addLast(value);
                }

                while (!deque.isEmpty()) {
                    queue.add(deque.removeFirst());
                }
            }

            answer = Math.max(answer, Math.abs((Long) queue.poll()));
        }

        return answer;
    }

    public static Long calculation(long a, long b, char sign) {
        long result = 0;
        switch (sign) {
            case '*':
                result = a * b;
                break;
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
        }
        
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(solution("100-200*300-500+20"));
        System.out.println(solution("50*6-3*2"));
    }
}
