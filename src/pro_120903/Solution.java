package pro_120903;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        List<String> stringList = Arrays.stream(s1).collect(Collectors.toList());

        for (String string : s2) {
            if (stringList.contains(string)) answer++;
        }
        return answer;
    }
}
