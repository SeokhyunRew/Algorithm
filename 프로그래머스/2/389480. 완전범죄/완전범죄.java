import java.util.Arrays;

class Solution {
    public int solution(int[][] info, int n, int m) {
        final int INF = Integer.MAX_VALUE / 2;
        // dp[b] = 현재까지 B흔적이 b일 때, A흔적의 최소 합
        int[] dp = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int[] item : info) {
            int aCost = item[0], bCost = item[1];
            int[] next = new int[m];
            Arrays.fill(next, INF);

            for (int bSum = 0; bSum < m; bSum++) {
                int aSum = dp[bSum];
                if (aSum >= INF) continue;

                // 1) 이 물건을 A가 훔칠 때
                next[bSum] = Math.min(next[bSum], aSum + aCost);

                // 2) 이 물건을 B가 훔칠 때
                int nb = bSum + bCost;
                if (nb < m) {
                    next[nb] = Math.min(next[nb], aSum);
                }
            }
            dp = next;
        }

        // B흔적이 0~m-1 범위에서 A흔적이 최소가 되는 값 찾기
        int answer = Arrays.stream(dp).min().orElse(INF);
        return (answer < n) ? answer : -1;
    }
}
