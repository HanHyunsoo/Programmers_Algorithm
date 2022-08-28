package pro_70129;

public class Solution {
    static int[] answer = {0, 0};

    public int[] solution(String s) {
        if (s.length() == 1) {
            return answer;
        }

        StringBuilder sb = new StringBuilder();

        int countZero = (int) s.chars()
                .filter(c -> {
                    if (c == '0') {
                        answer[1]++;
                        return true;
                    }
                    return false;
                })
                .count();


        s = Integer.toBinaryString(s.length() - countZero);
        answer[0]++;
        return solution(s);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("110010101001"));
        System.out.println();
    }
}
