import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        // dp[len][lastDigit][mask] = 개수
        int FULL = (1 << 10) - 1;
        long[][][] dp = new long[N + 1][10][1 << 10];

        // 길이 1 초기화: 1~9만 가능 (0으로 시작 불가)
        for (int d = 1; d <= 9; d++) {
            dp[1][d][1 << d] = 1;
        }

        for (int len = 2; len <= N; len++) {
            for (int last = 0; last <= 9; last++) {
                for (int mask = 0; mask <= FULL; mask++) {
                    long cur = dp[len - 1][last][mask];
                    if (cur == 0) continue;

                    // 다음 자릿수로 이동 (계단 수: ±1)
                    if (last - 1 >= 0) {
                        int nlast = last - 1;
                        int nmask = mask | (1 << nlast);
                        dp[len][nlast][nmask] = (dp[len][nlast][nmask] + cur) % MOD;
                    }
                    if (last + 1 <= 9) {
                        int nlast = last + 1;
                        int nmask = mask | (1 << nlast);
                        dp[len][nlast][nmask] = (dp[len][nlast][nmask] + cur) % MOD;
                    }
                }
            }
        }

        long ans = 0;
        for (int last = 0; last <= 9; last++) {
            ans = (ans + dp[N][last][FULL]) % MOD;
        }
        System.out.println(ans);
    }
}
