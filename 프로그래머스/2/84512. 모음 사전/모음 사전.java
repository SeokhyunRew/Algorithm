import java.util.*;

class Solution {
    private final char[] VOWELS = {'A','E','I','O','U'};
    private String target;   
    private int count = 0;    
    private int answer = 0;  

    public int solution(String word) {
        target = word;
        dfs(new StringBuilder());
        return answer;
    }

    private boolean dfs(StringBuilder curr) {
        if (curr.length() > 0) {
            count++;
            if (curr.toString().equals(target)) {
                answer = count;
                return true;
            }
        }
        if (curr.length() == 5) {
            return false;
        }
        for (char c : VOWELS) {
            curr.append(c);
            if (dfs(curr)) {
                return true;    
            }
            curr.deleteCharAt(curr.length() - 1); 
        }
        return false;
    }
}