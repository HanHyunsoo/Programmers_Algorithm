package pro_43164;

import java.util.*;

class Solution {

    static int n;
    static boolean[] visited;
    static List<String> answers = new ArrayList<>();

    public void dfs(int depth, String node, String answer, String[][] tickets) {
        if (depth == n) {
            answers.add(answer);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && node.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(depth + 1, tickets[i][1], answer + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }

    public String[] solution(String[][] tickets) {
        n = tickets.length;
        visited = new boolean[n];

        dfs(0, "ICN", "ICN", tickets);

        Collections.sort(answers);

        return answers.get(0).split(" ");
    }
}