class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];

        // 마지막 행부터 채워 넣기
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = triangle[n-1][i];
        }

        // 아래에서 위로 누적합 계산
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[row][col] = triangle[row][col] + Math.max(dp[row+1][col], dp[row+1][col+1]);
            }
        }

        return dp[0][0];  // 꼭대기에서의 최대 합
    }
}
