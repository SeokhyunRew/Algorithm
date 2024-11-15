class Solution {
    public String solution(int age) {
        StringBuilder answer = new StringBuilder();
        
        for(char c : String.valueOf(age).toCharArray()){
            char transformed = (char) ('a' + (c - '0'));
             answer.append(transformed);
        }
        
        return answer.toString();
    }
}