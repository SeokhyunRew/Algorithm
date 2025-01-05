class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int temp = 1;
        
        while(temp!=n+1){
            if(temp%2==1) answer.append('수');
            else answer.append('박');
            temp++;
        }
        
        return answer.toString();
    }
}