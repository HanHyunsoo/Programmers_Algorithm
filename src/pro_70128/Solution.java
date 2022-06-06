package pro_70128;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Solution {
    public int solution(int[] a, int[] b) {
        AtomicInteger answer = new AtomicInteger();
        IntStream.range(0, a.length)
                .forEach(x -> answer.addAndGet(a[x] * b[x]));

        return answer.get();
    }
}
