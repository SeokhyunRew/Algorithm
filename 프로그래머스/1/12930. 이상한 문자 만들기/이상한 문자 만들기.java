import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int temp;
        
        String[] str_arr = s.split(" ", -1);
        
        for(String str : str_arr){
            temp =0;
            for(char c : str.toCharArray()){
                if(temp%2==0) answer.append(Character.toUpperCase(c));
                else answer.append(Character.toLowerCase(c));
                temp++;
            }
            answer.append(" ");
        }
        answer.delete(answer.length()-1,answer.length());
        
        return answer.toString();
    }
}