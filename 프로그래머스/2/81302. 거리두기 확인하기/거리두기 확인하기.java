import java.util.*;

class Solution {
    
    // BFS 탐색을 위한 방향 배열 (상하좌우)
    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            String[] place = places[i];
            char[][] room = new char[5][5];

            // String[]을 char[][]로 변환
            for (int j = 0; j < 5; j++) {
                room[j] = place[j].toCharArray();
            }

            // checkRoom 함수로 해당 대기실의 거리두기 준수 여부(1 또는 0)를 계산
            answer[i] = checkRoom(room);
        }

        return answer;
    }

    /**
     * 대기실 전체를 검사하여 거리두기 준수 여부를 반환 (1: 준수, 0: 위반)
     */
    private int checkRoom(char[][] room) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (room[r][c] == 'P') {
                    // 'P'를 발견하면 해당 응시자 주변의 거리두기를 BFS로 검사
                    if (isViolated(room, r, c)) {
                        return 0; // 단 하나의 위반이라도 발견되면 즉시 0 반환
                    }
                }
            }
        }
        return 1; // 모든 'P'가 검사를 통과하면 1 반환
    }

    /**
     * 특정 'P' (startR, startC)에서 BFS를 시작하여 거리 2 이내 위반 검사
     */
    private boolean isViolated(char[][] room, int startR, int startC) {
        
        // 큐에 {행, 열, 거리} 저장
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startR, startC, 0}); 
        
        boolean[][] visited = new boolean[5][5];
        visited[startR][startC] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            int d = current[2];

            if (d >= 2) continue; // 거리 2 초과는 더 이상 탐색하지 않음

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && !visited[nr][nc]) {
                    
                    if (room[nr][nc] == 'P') {
                        // 1. **거리 1 위반:** d=0 (출발지)에서 이동하면 거리 1이므로 무조건 위반.
                        // 2. **거리 2 위반:** d=1 (중간 'O')에서 이동하면 거리 2가 되며, 이는 중간에 'X'가 없다는 의미이므로 위반.
                        return true; 
                    } 
                    
                    else if (room[nr][nc] == 'O') {
                        // 빈 테이블('O')을 통해서만 다음 칸으로 이동하여 거리를 1 증가
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc, d + 1});
                    }
                    
                    // 'X' (파티션)는 탐색 경로를 막으므로 무시됨
                }
            }
        }
        return false;
    }
}