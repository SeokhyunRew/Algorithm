import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> usedWords = new HashSet<>();
        usedWords.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];
            
            // 규칙 위반 1: 끝말잇기 불일치
            // 규칙 위반 2: 이미 등장한 단어
            if (curr.length() <= 1 || usedWords.contains(curr) || prev.charAt(prev.length() - 1) != curr.charAt(0)) {
                int person = (i % n) + 1;
                int round = (i / n) + 1;
                return new int[] { person, round };
            }
            usedWords.add(curr);
        }
        
        return new int[] { 0, 0 };
    }
}
