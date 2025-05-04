import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        char prev=words[0].charAt(words[0].length()-1);
        String curr;
        
        Set<String> useWords = new HashSet<>();
        useWords.add(words[0]);
        
        for(int i=1; i<words.length; i++){
            curr=words[i];
            if(useWords.contains(curr)||prev!=curr.charAt(0)){
                answer[0] = (i)%n+1;
                if((i+1)%n==0) answer[1] = (i+1)/n;
                else answer[1] = (i+1)/n+1;
                return answer;
            }
            useWords.add(curr);
            prev = curr.charAt(curr.length()-1);
        }

        return answer;
    }
}