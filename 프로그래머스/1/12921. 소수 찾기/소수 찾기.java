class Solution {
    public int solution(int n) {
        if (n < 2) return 0; 

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true; 
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                answer++;
            }
        }

        return answer;
    }
}
