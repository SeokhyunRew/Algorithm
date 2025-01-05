class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++){
            if(divisor(i)%2==0) answer += i;
            else answer -= i;
        }
        
        return answer;
    }
    
    private int divisor(int num){
        int temp = 0;
        
        for(int i=1; i<=Math.sqrt(num); i++){
            if(num%i==0){
                if(i==Math.sqrt(num)){
                    temp ++;
                    continue;
                }
                temp += 2;
            }
        }
        
        return temp;
    }
}