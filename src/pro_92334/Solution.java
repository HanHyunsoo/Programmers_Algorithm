package pro_92334;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public static int countReport(Map<String, Integer> banCountMap, Set<String> set, int k) {
        AtomicInteger count = new AtomicInteger();

        set.stream().filter(x -> banCountMap.get(x) >= k).forEach(x -> count.incrementAndGet());

        return count.get();
    }
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> banCountMap = new LinkedHashMap<>();
        Map<String, Set<String>> reportMap = new LinkedHashMap<>();

        for (String id : id_list) {
            banCountMap.put(id, 0);
            reportMap.put(id, new HashSet<>());
        }

        for (String temp : report) {
            String toUser = temp.split(" ")[0];
            String fromUser = temp.split(" ")[1];

            Set<String> set = reportMap.get(toUser);

            if (!set.contains(fromUser)) {
                set.add(fromUser);
                banCountMap.put(fromUser, banCountMap.get(fromUser) + 1);
            }
        }

        List<Integer> answerList = new ArrayList<>();
        reportMap.values().forEach(x -> answerList.add(countReport(banCountMap, x, k)));

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}