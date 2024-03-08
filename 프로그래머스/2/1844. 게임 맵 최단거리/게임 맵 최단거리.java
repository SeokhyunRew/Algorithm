import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1));

        int rows = maps.length;
        int cols = maps[0].length;
        boolean[][] visited = new boolean[rows][cols];

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            int row = currentPoint.row;
            int col = currentPoint.col;
            int distance = currentPoint.distance;

            if (row == rows - 1 && col == cols - 1) {
                return distance;
            }

            visited[row][col] = true;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if ((i != 0 && j != 0) || (i == 0 && j == 0)) {
                        continue;
                    }
                    int newRow = row + i;
                    int newCol = col + j;
                    if (isValid(maps.length, maps[0].length, newRow, newCol) && !visited[newRow][newCol] && maps[newRow][newCol] == 1) {
                        visited[newRow][newCol] = true;
                        queue.add(new Point(newRow, newCol, distance + 1));
                    }
                }
            }
        }

        return -1;
    }

    static class Point {
        int row;
        int col;
        int distance;

        public Point(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    static boolean isValid(int rows, int cols, int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
