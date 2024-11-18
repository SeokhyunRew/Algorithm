class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        for(char ch : my_string.toCharArray()){
            sb.append((Character.isUpperCase(ch))?Character.toLowerCase(ch):Character.toUpperCase(ch));
        }
        
        String answer = sb.toString();
        
        return answer;
    }
}