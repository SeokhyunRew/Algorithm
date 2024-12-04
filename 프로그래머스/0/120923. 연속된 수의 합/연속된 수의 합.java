class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int temp = (int) total/num;
        
        if(num%2==0){
            for(int i=0; i<num; i++){
                answer[i] = temp+i-((int)num/2)+1;
            }
        }else{
            for(int i=0; i<num; i++){
                answer[i] = temp+i-((int)num/2);
            }
        }
        
        return answer;
    }
}