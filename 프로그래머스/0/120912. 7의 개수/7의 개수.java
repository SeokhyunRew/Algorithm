class Solution {
    public int solution(int[] array) {
        int answer = 0;
        char[] temp;
        
        for(int i : array){
            temp = String.valueOf(i).toCharArray();
            for(char ch : temp){
                if(ch=='7') answer++;
            }  
        }
        
        return answer;
    }
}