class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        
        for (char s : my_string.toCharArray()) {
            answer += String.valueOf(s).repeat(n);
        }
        
        return answer;
    }
}