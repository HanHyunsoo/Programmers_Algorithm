package pro_42626;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(priorityQueue::add);
        int answer = 0;

        while (priorityQueue.size() >= 2 && priorityQueue.peek() < K) {
            int topFood = priorityQueue.poll();
            int nextFood = priorityQueue.poll();

            priorityQueue.add(topFood + nextFood * 2);
            answer++;
        }

        answer = (priorityQueue.stream().filter(x -> x < K).findFirst().isEmpty()) ? answer : -1;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 0, 0}, 1));;
    }
}
