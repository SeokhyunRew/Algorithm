class Solution {
    public int solution(int n) {
        int answer = 0;
        int temp;
        
        for(int i=1; i<=10; i++){
            temp = 1;
            for(int j=1; j<=i; j++){
                temp *= j;
            }
            
            if(temp > n){
                break;    
            }else if(temp == n){
                answer++;
                break;
            }
            
            answer ++;
        }
        
        return answer;
    }
}