class Solution {
    public int solution(int hp) {
        int answer = 0;
        int[] hpArray = {5, 3, 1};
        
        for(int num : hpArray){
            answer += hp/num;
            hp = hp%num;   
        }
        
        return answer;
    }
}