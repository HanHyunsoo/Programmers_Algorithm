package pro_77485;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    static int[][] matrix;

    public static int[] solution(int rows, int columns, int[][] queries) {
        matrix = new int[rows + 1][columns + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                matrix[i][j] = ((i - 1) * columns) + j;
            }
        }
        List<Integer> answer = new ArrayList<>();

        for (int[] query : queries) {
            List<Object> dequeList = getDequeList(query);

            Deque<Integer> valueDeque = (Deque<Integer>) dequeList.get(0);
            Deque<Point> pointDeque = (Deque<Point>) dequeList.get(1);
            answer.add((Integer) dequeList.get(2));

            valueDeque.addFirst(valueDeque.pollLast());

            while (!valueDeque.isEmpty()) {
                int value = valueDeque.pollFirst();
                Point point = pointDeque.pollFirst();

                matrix[point.y][point.x] = value;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static List<Object> getDequeList(int[] query) {
        Deque<Integer> valueDeque = new ArrayDeque<>();
        Deque<Point> pointDeque = new ArrayDeque<>();
        int min = Integer.MAX_VALUE;

        for (int i = query[1]; i <= query[3]; i++) {
            min = Math.min(min, matrix[query[0]][i]);
            valueDeque.add(matrix[query[0]][i]);
            pointDeque.add(new Point(query[0], i));
        }

        for (int i = query[0] + 1; i <= query[2] ; i++) {
            min = Math.min(min, matrix[i][query[3]]);
            valueDeque.add(matrix[i][query[3]]);
            pointDeque.add(new Point(i, query[3]));
        }

        for (int i = query[3] - 1; i >= query[1]; i--) {
            min = Math.min(min, matrix[query[2]][i]);
            valueDeque.add(matrix[query[2]][i]);
            pointDeque.add(new Point(query[2], i));
        }

        for (int i = query[2] - 1; i >= query[0] + 1; i--) {
            min = Math.min(min, matrix[i][query[1]]);
            valueDeque.add(matrix[i][query[1]]);
            pointDeque.add(new Point(i, query[1]));
        }

        return List.of(valueDeque, pointDeque, min);
    }

    public static void main(String[] args) {
        solution(6, 6, new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}});
    }
}

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
