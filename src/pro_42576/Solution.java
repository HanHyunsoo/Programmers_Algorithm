package pro_42576;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> playerMap = new HashMap<>();
        String answer = "";

        Arrays.stream(participant).forEach(x -> playerMap.put(x, playerMap.getOrDefault(x, 0) + 1));
        Arrays.stream(completion).forEach(x -> playerMap.put(x, playerMap.get(x) - 1));

        for (String player : playerMap.keySet()) {
            if (playerMap.get(player) == 1) {
                answer = player;
                break;
            }
        }

        return answer;
    }
}
