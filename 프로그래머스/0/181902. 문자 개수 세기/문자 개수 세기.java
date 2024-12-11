class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for(char ch : my_string.toCharArray()){
            if(Character.isUpperCase(ch)) answer[ch - 65] += 1;
            else answer[ch - 97 + 26] += 1;
        }
        
        return answer;
    }
}