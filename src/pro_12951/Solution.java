package pro_12951;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String solution(String s) {
        s += " ";
        s = s.toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                while (!deque.isEmpty()) {
                    sb.append(deque.removeFirst());
                }
                sb.append(' ');
                continue;
            }

            if (deque.isEmpty()) {
                deque.addLast(Character.toUpperCase(c));
            } else {
                deque.addLast(c);
            }
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
