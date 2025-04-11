import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int H = park.length;
        int W = park[0].length;
        int[][] grid = new int[H][W];
        int[][] sum = new int[H + 1][W + 1];

        // 1. 문자열을 숫자로 변환
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                grid[i][j] = park[i][j].trim().equals("-1") ? 1 : 0;
            }
        }

        // 2. 누적합 배열 만들기
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                sum[i][j] = grid[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }

        // 3. mats 정렬 (내림차순)
        Arrays.sort(mats);
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];

            for (int y = 0; y <= H - size; y++) {
                for (int x = 0; x <= W - size; x++) {
                    int areaSum = sum[y + size][x + size] - sum[y][x + size] - sum[y + size][x] + sum[y][x];
                    if (areaSum == size * size) {
                        return size; // 가장 큰 정사각형 발견 → 바로 반환
                    }
                }
            }
        }

        return -1;
    }
}
