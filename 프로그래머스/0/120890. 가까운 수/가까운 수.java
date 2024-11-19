class Solution {
    public int solution(int[] array, int n) {
        int answer = Integer.MAX_VALUE;
        
        for(int num : array){
            if(Math.abs(num-n)<Math.abs(answer-n)){
                answer = num;
            }else if(Math.abs(num-n)==Math.abs(answer-n)){
                answer = (num<answer)?num:answer;
            }
        }
        
        return answer;
    }
}