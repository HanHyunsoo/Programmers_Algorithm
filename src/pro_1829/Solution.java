package pro_1829;

public class Solution {
    // dfs 에서 해당 인덱스의 값을 순회했는지 판단하기 위한 2차원 배열
    public static int[][] visited;
    public static int[][] matrix;

    // 상, 하, 좌, 우를 판별하기 위한 배열들
    public static int[] moveX = {0, 0, -1, 1};
    public static int[] moveY = {1, -1, 0, 0};

    public static int count, M, N;

    public static void dfs(int y, int x, int color) {
        visited[y][x] = 1;
        count++;

        for (int i = 0; i < 4; i++) {
            int ny = y + moveX[i];
            int nx = x + moveY[i];

            if (0 <= ny && ny < M && 0 <= nx && nx < N) {
                if (visited[ny][nx] == 0 && matrix[ny][nx] == color) {
                    dfs(ny, nx, color);
                }
            }
        }
    }

    public static int[] solution(int m, int n, int[][] picture) {
        M = m;
        N = n;
        visited = new int[M][N];
        matrix = new int[M][N];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = picture[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] != 0 && visited[i][j] == 0) {
                    numberOfArea++;
                    count = 0;
                    dfs(i, j, matrix[i][j]);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void main(String[] args) {
        int[][] temp = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        solution(6, 4, temp);
    }
}
