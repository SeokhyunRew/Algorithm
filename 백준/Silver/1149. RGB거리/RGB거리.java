import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 집의 개수
        int[][] cost = new int[N][3]; // 각 집을 R, G, B로 칠하는 비용

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); // R
            cost[i][1] = Integer.parseInt(st.nextToken()); // G
            cost[i][2] = Integer.parseInt(st.nextToken()); // B
        }

        // DP 테이블 초기화
        int[][] dp = new int[N][3];
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        // 점화식
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0]; // 이번에 빨강
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1]; // 이번에 초록
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2]; // 이번에 파랑
        }

        int result = Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
        System.out.println(result);
    }
}
