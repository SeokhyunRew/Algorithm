class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[m+1][n+1];
        int MOD = 1_000_000_007;
        
        boolean[][] puddleMap = new boolean[m+1][n+1];
        
        for(int[] arr : puddles) puddleMap[arr[0]][arr[1]] = true;
        
        dp[1][1] = 1;
        
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(i==1&&j==1) continue;
                
                if(puddleMap[i-1][j] && puddleMap[i][j-1]) dp[i][j] = 0;
                else if(puddleMap[i-1][j]) dp[i][j] = dp[i][j-1];
                else if(puddleMap[i][j-1]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = (dp[i][j-1]+dp[i-1][j])% MOD;
            }
        }
        
        return dp[m][n];
    }
}