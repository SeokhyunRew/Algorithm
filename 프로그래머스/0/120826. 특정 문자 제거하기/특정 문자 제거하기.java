class Solution {
    public String solution(String my_string, String letter) {
        String answer = ""; 
        String temp = "";
        
        
        for(char c : my_string.toCharArray()){
            temp = String.valueOf(c);
            
            if(temp.equals(letter)){
                temp = "";
            }
            
            answer += temp;
        }
        
        return answer;
    }
}