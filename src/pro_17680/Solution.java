package pro_17680;

import java.util.LinkedList;

public class Solution {
    public static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        int answer = 0;
        LinkedList<String> queue = new LinkedList<>();

        for (String city : cities) {
            if (queue.contains(city.toLowerCase())) {
                queue.addLast(queue.remove(queue.indexOf(city.toLowerCase())));
                answer += 1;
            } else {
                if (queue.size() >= cacheSize) {
                    queue.removeFirst();
                }
                queue.addLast(city.toLowerCase());
                answer += 5;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
    }
}
