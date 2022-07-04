package pro_42889;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class Solution {
    static class StageInfo {
        int stage;
        double failureRate;

        public StageInfo(int stage, double failureRate) {
            this.stage = stage;
            this.failureRate = failureRate;
        }
    }

    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Integer> stageMap = new HashMap<>();
        IntStream.range(1, N + 1).forEach(x -> stageMap.put(x , 0));
        Arrays.stream(stages).filter(stageMap::containsKey).forEach(x -> stageMap.put(x, stageMap.get(x) + 1));

        AtomicReference<Double> player = new AtomicReference<>((double) stages.length);
        List<StageInfo> stageInfoList = new ArrayList<>();

        IntStream.range(1, N + 1).forEach(x -> {
            int failPlayer = stageMap.get(x);
            double failureRate = failPlayer / player.get();
            failureRate = (Double.isInfinite(failureRate) || Double.isNaN(failureRate)) ? 0.0 : failureRate;
            StageInfo stageInfo = new StageInfo(x, failureRate);
            stageInfoList.add(stageInfo);
            player.updateAndGet(v -> v - failPlayer);
        });

        Comparator<StageInfo> comparator = Comparator.comparingDouble(o -> o.failureRate);
        stageInfoList.sort(comparator.reversed());

        return stageInfoList.stream().mapToInt(x -> x.stage).toArray();
    }

    public static void main(String[] args) {
        new Solution().solution(5, new int[]{3, 3, 3, 3});
    }
}
