import java.util.*;
class Solution {
    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();
        char[] array = my_string.toLowerCase().toCharArray();
        Arrays.sort(array);
            
        for(char c : array){
            answer.append(c);
        }
        
        return answer.toString();
    }
}