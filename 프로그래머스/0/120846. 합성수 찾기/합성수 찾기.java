class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n<4){
            return answer;
        }
        
        for(int i=4; i<=n; i++){
            
            if(i==5 || i==7){
                continue;
            }
            
            if(i%2==0 || i%3==0 || i%5==0 || i%7==0){
                answer ++;
            }    
        }
        
        return answer;
    }
}