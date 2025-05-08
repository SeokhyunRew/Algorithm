import java.util.*;

class Solution {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        int n = storage.length, m = storage[0].length();
        int answer = n * m;

        // 1) 패딩 포함한 지도 생성
        String[][] arr = new String[n + 2][m + 2];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i + 1][j + 1] = storage[i].substring(j, j + 1);
        for (int i = 0; i < n + 2; i++) {
            arr[i][0] = "1";
            arr[i][m + 1] = "1";
        }
        for (int j = 0; j < m + 2; j++) {
            arr[0][j] = "1";
            arr[n + 1][j] = "1";
        }

        // 2) 요청 처리
        for (String req : requests) {
            // forklift: 길이 1
            if (req.length() == 1) {
                // 2-1) 외부(0,0)에서 빈공간("1")만 BFS
                boolean[][] visited = new boolean[n + 2][m + 2];
                Queue<int[]> q = new LinkedList<>();
                visited[0][0] = true;
                q.offer(new int[]{0, 0});
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int d = 0; d < 4; d++) {
                        int nx = cur[0] + dx[d], ny = cur[1] + dy[d];
                        if (nx < 0 || ny < 0 || nx >= n + 2 || ny >= m + 2) continue;
                        if (!visited[nx][ny] && arr[nx][ny].equals("1")) {
                            visited[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
                // 2-2) 접근 가능한 컨테이너만 제거
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (arr[i][j].equals(req)) {
                            for (int d = 0; d < 4; d++) {
                                int nx = i + dx[d], ny = j + dy[d];
                                if (visited[nx][ny]) {
                                    arr[i][j] = "1";
                                    answer--;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            // crane: 길이 2
            else {
                String target = req.substring(0, 1);
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (arr[i][j].equals(target)) {
                            arr[i][j] = "1";
                            answer--;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
