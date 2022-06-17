package pro_1844;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int[][] moveXY = {{0, 1, 0, -1}, {-1, 0, 1, 0}};
    static int[][] visited;
    static int n, m;
    static int result = -1;

    public static int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];
        n = maps.length;
        m = maps[maps.length - 1].length;
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                visited[i][j] = (maps[i][j] == 1) ? 0 : 1;
            }
        }

        queue.add(new Node(0, 0, 1));
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.y == n - 1 && node.x == m - 1) {
                result = node.count;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = node.y + moveXY[0][i];
                int nx = node.x + moveXY[1][i];

                if (0 <= ny && ny < n && 0 <= nx && nx < m) {
                    if (maps[ny][nx] == 1 && visited[ny][nx] == 0) {
                        visited[ny][nx] = 1;
                        queue.add(new Node(ny, nx, node.count + 1));
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
    }
}

class Node {
    int y;
    int x;
    int count;

    public Node(int y, int x, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }
}