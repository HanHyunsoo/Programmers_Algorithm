package pro_12905;

public class Solution {

    public int solution(int[][] board) {
        int answer = 0;

        int[][] dp = new int[board.length + 1][board[0].length + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (board[i - 1][j - 1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        return answer * answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{0,0,1,1},{1,1,1,1}}));
    }
}
