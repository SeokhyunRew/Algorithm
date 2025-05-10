import java.util.*;

class Solution {
    public int solution(String word) {
        final String VOWELS = "AEIOU";
        List<String> list = new ArrayList<>();
        
        dfs(new StringBuilder(), 0, VOWELS, list);
        
        return list.indexOf(word);
    }
    
    private void dfs(StringBuilder sb, int len, String VOWELS, List<String> list) {
        if (len > 5) return;
        list.add(sb.toString());
        for (int i = 0; i < 5; i++) {
            sb.append(VOWELS.charAt(i));   
            dfs(sb, len + 1, VOWELS, list);
            sb.deleteCharAt(sb.length() - 1); 
        }
    }
}
