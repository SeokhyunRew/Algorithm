class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        char k_char = (char) (k +'0');

        for(int start=i; start<=j; start++){
            for(char c : String.valueOf(start).toCharArray()){
                if(c==k_char) answer ++;
            }
        }
        
        return answer;
    }
}