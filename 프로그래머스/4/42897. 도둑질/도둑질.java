class Solution {
    public int solution(int[] money) {
        int[] dp = new int[money.length-1];
        
        if(money.length==0) return 0;
        else if(money.length==1) return money[0];
        else if(money.length==2) return Math.max(money[0], money[1]);
        
        //1번째를 안 골랐을때
        dp[0] = money[1];
        dp[1] = Math.max(money[1], money[2]);
        
        for(int i=2; i<money.length-1; i++) dp[i] = Math.max(money[i+1]+dp[i-2], dp[i-1]);
        int firstAns = dp[money.length-2];
        
        //마지막을 안고를 때
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
        
        for(int i=2; i<money.length-1; i++) dp[i] = Math.max(money[i]+dp[i-2], dp[i-1]);
        int secondAns = dp[money.length-2];
        
        return Math.max(firstAns, secondAns);
    }
}