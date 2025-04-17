import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 좌표 2배 처리
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        // 사각형 좌표도 전부 2배 처리
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < 4; j++) {
                rectangle[i][j] *= 2;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[102][102]; // 최대 좌표는 100까지 가능 → 여유있게 102

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        queue.offer(new int[] {characterX, characterY, 0});
        visited[characterX][characterY] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];

            if (x == itemX && y == itemY) {
                return dist / 2; // 거리의 절반이 실제 이동 거리
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!visited[nx][ny] && canGo(rectangle, nx, ny)) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }

        return -1;
    }

    private boolean canGo(int[][] rectangle, int x, int y) {
        boolean edge = false;
        boolean inside = false;

        for (int[] box : rectangle) {
            int x1 = box[0], y1 = box[1], x2 = box[2], y2 = box[3];

            // 외곽선인지 체크
            if ((x == x1 || x == x2) && y >= y1 && y <= y2) edge = true;
            else if ((y == y1 || y == y2) && x >= x1 && x <= x2) edge = true;

            // 내부에 포함되는지 체크
            if (x > x1 && x < x2 && y > y1 && y < y2) inside = true;
        }

        return edge && !inside;
    }
}
