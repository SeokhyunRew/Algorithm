import java.util.*;
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        for(char ch : my_string.toCharArray()){
            if(Character.isDigit(ch)){
                sb.append(ch);
            }else if(Character.isLowerCase(ch) || Character.isUpperCase(ch)){
                if(sb.length() != 0){
                    answer += Integer.parseInt(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        
        if (sb.length() != 0) {
            answer += Integer.parseInt(sb.toString());
        }
        
        return answer;
    }
}