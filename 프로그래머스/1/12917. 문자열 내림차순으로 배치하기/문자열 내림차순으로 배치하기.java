import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder lower = new StringBuilder();
        StringBuilder upper = new StringBuilder();
        
        for(char c : s.toCharArray()){
            if(Character.isUpperCase(c)) upper.append(c);
            else lower.append(c);
        }
        
        char[] lower_arr = lower.toString().toCharArray();
        char[] upper_arr = upper.toString().toCharArray();
        
        Arrays.sort(lower_arr);
        Arrays.sort(upper_arr);
        
        lower.setLength(0);
        upper.setLength(0);
        
        for(char c : lower_arr){
            lower.append(c);
        }
        
        for(char c : upper_arr){
            upper.append(c);
        }
        
        return lower.reverse().append(upper.reverse()).toString();
    }
}