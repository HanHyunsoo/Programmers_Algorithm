package pro_64065;

import java.util.*;

public class Solution {
    public static int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        List<List<Integer>> tupleList = new ArrayList<>();
        for (String tuple : s.split("}.\\{")) {
            List<Integer> list = new ArrayList<>();

            for (String value : tuple.split(",")) {
                list.add(Integer.valueOf(value));
            }
            tupleList.add(list);
        }

        tupleList.sort(Comparator.comparingInt(List::size));

        Set<Integer> set = new HashSet<>();
        List<Integer> answer = new ArrayList<>();

        for (List<Integer> tuple : tupleList) {
            for (Integer value : tuple) {
                if (!set.contains(value)) {
                    answer.add(value);
                    set.add(value);
                }
            }
        }


        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        String s = 	"{{20,111},{111}}";
        solution(s);
    }
}
