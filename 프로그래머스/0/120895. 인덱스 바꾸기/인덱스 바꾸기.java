class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] answer = my_string.toCharArray();
        
        answer[num1] = my_string.charAt(num2);
        answer[num2] = my_string.charAt(num1);        
        
        return String.valueOf(answer);
    }
}