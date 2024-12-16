class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n==0) return 0;
        
        for(int i=1; i<=Math.sqrt(n); i++){
            if(n%i==0){
                if(i==n/i){
                    answer += i;
                    continue;
                }
                answer = answer + i + n/i;
            }
        }
        
        return answer;
    }
}