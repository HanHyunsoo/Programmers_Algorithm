package pro_43165;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(numbers[0], 0));
        queue.add(new Node(-numbers[0], 0));

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.level == numbers.length - 1) {
                if (temp.number == target) {
                    answer++;
                }
                continue;
            }

            queue.add(new Node(temp.number + numbers[temp.level + 1], temp.level + 1));
            queue.add(new Node(temp.number - numbers[temp.level + 1], temp.level + 1));
        }

        return answer;
    }

    public static void main(String[] args) {
       solution(new int[]{4, 1, 2, 1}, 4);
    }
}

class Node {
    int number;
    int level;

    public Node(int number, int level) {
        this.number = number;
        this.level = level;
    }
}
