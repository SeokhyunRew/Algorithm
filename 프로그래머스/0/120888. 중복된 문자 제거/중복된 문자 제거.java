import java.util.*;
class Solution {
    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();
        Set<Character> set = new LinkedHashSet<>();
        
        for(char c : my_string.toCharArray()){
            set.add(c);
        }
        
        for(char c : set){
            answer.append(Character.toString(c));
        }
            
        return answer.toString();
    }
}