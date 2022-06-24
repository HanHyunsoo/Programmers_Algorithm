package pro_42890;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    static HashMap<String, Set<String>> map = new HashMap<>();
    static List<List<Integer>> superKeys = new ArrayList<>();
    static List<List<Integer>> candidateKeys = new ArrayList<>();
    static int col, row;

    public static int solution(String[][] relation) {
        row = relation.length;
        col = relation[0].length;

        for (String[] tuple : relation) {
            setValues(tuple, "", "", 0);
        }

        superKeys.sort(Comparator.comparingInt(List::size));

        if (!superKeys.isEmpty()) {
            candidateKeys.add(superKeys.get(0));
        }

        for (List<Integer> superKey : superKeys) {
            if (!compareIndex(superKey)) {
                candidateKeys.add(superKey);
            }
        }

        return candidateKeys.size();
    }

    public static void setValues(String[] tuple, String key, String value, int count) {
        if (count == col) {
            if (!map.containsKey(key)) {
                map.put(key, new HashSet<>());
            }
            map.get(key).add(value.strip());

            if (row == map.get(key).size()) {
                superKeys.add(Arrays.stream(key.split("")).map(Integer::parseInt).collect(Collectors.toList()));
            }
            return;
        }

        setValues(tuple, key, value + " -", count + 1);
        setValues(tuple, key + count, value + " " + tuple[count], count + 1);
    }

    public static boolean compareIndex(List<Integer> superKey) {
        for (List<Integer> candidateKey : candidateKeys) {
            if (superKey.containsAll(candidateKey)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
//        solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}});
        System.out.println(solution(new String[][]{{"a", "1", "aaa", "c", "ng"}, {"b", "1", "bbb", "c", "g"}, {"c", "1", "aaa", "d", "ng"}, {"d", "2", "bbb", "d", "ng"}}));
    }
}
