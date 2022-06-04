package pro_42748;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int index = 0;
        int[] answer = new int[commands.length];

        for (int[] command : commands) {
            int[] tempArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(tempArray);
            answer[index++] = tempArray[command[2] - 1];
        }
        return answer;
    }
}
