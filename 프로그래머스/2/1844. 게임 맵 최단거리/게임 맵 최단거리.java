import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        //bfs 탐색 후 넣을 queue 생성
        Queue<Point> queue = new LinkedList<>();
        //초기 값 point객체 형식으로 저장
        queue.add(new Point(0, 0, 1));

        int rows = maps.length;
        int cols = maps[0].length;
        //방문 체크 배열 생성
        boolean[][] visited = new boolean[rows][cols];

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            int row = currentPoint.row;
            int col = currentPoint.col;
            int distance = currentPoint.distance;

            //종점 도착 시 프로그램 종료
            if (row == rows - 1 && col == cols - 1) {
                return distance;
            }
            //방문 확인 업데이트
            visited[row][col] = true;
            //방문 노드 기준 위, 아래, 왼쪽, 오른쪽 팀색
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    //대각선, 자기 자신 탐색 피함
                    if ((i != 0 && j != 0) || (i == 0 && j == 0)) {
                        continue;
                    }
                    int newRow = row + i;
                    int newCol = col + j;
                    //탐색 가능한 칸인지 확인
                    if (isValid(maps.length, maps[0].length, newRow, newCol) && !visited[newRow][newCol] && maps[newRow][newCol] == 1) {
                        visited[newRow][newCol] = true;
                        queue.add(new Point(newRow, newCol, distance + 1));
                    }
                }
            }
        }
        //정점 도착 못했으면 막힌 것
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