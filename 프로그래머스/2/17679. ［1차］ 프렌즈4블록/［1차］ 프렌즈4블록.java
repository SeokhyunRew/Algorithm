class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        String[][] map = new String[m][n];

        // 문자열 배열 -> 2차원 문자 배열로 변환
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = String.valueOf(board[i].charAt(j));
            }
        }

        while (true) {
            boolean[][] check = new boolean[m][n];
            int count = 0;

            // 2x2 블록 찾기
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    String s = map[i][j];
                    if (!s.equals("0") &&
                        s.equals(map[i + 1][j]) &&
                        s.equals(map[i][j + 1]) &&
                        s.equals(map[i + 1][j + 1])) {
                        check[i][j] = check[i + 1][j] = true;
                        check[i][j + 1] = check[i + 1][j + 1] = true;
                    }
                }
            }

            // 지워질 블록 세기 및 지우기
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j]) {
                        map[i][j] = "0";
                        count++;
                    }
                }
            }

            if (count == 0) break; // 더 이상 지울 게 없으면 종료
            answer += count;

            // 블록 떨어뜨리기
            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j].equals("0")) {
                        int k = i - 1;
                        while (k >= 0 && map[k][j].equals("0")) k--;
                        if (k >= 0) {
                            map[i][j] = map[k][j];
                            map[k][j] = "0";
                        }
                    }
                }
            }
        }

        return answer;
    }
}
