class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int temp = numbers.length-1;
        
        for(int i=0; i<k-1; i++){
            if(answer+2>temp){
                answer = answer+2-temp-1;
                continue;
            }
            answer += 2;
        }
        
        return numbers[answer];
    }
}