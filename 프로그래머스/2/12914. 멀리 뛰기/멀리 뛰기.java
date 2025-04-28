class Solution {
    public int solution(int n) {
        final int MOD = 1_234_567;
        if (n == 1) return 1;
        // 초기값
        int prev = 1;   // ways[1]
        int curr = 2;   // ways[2]
        if (n == 2) return curr;
        
        // 반복 계산
        for (int i = 3; i <= n; i++) {
            int next = (prev + curr) % MOD;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
