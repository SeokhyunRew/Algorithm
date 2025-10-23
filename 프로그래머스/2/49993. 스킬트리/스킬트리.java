import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Set<Character> definite = new HashSet<>();
        
        for(char c : skill.toCharArray()) definite.add(c);
        
        for(String curr : skill_trees){
            int index = 0;
            for(char c : curr.toCharArray()){
                if(definite.contains(c)){
                    if(skill.charAt(index)!=c){
                        answer--;
                        break;
                    }
                    index++;
                }
            }
            answer++;
        }
        
        return answer;
    }
}