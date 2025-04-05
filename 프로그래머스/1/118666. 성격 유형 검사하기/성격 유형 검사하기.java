import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        char target;
        int score;
        
        for(char c : "RTCFJMAN".toCharArray()) map.put(c,0);
        
        for(int i=0; i<survey.length; i++){
            score = choices[i];
            if(score>=1 && score<=3){
                target = survey[i].charAt(0);
                map.put(target, map.get(target)+4-score);    
            }else if(score>=5 && score<=7){
                target = survey[i].charAt(1);
                map.put(target, map.get(target)+score-4); 
            }
        }   
        
        answer.append((map.get('R')>=map.get('T'))?'R':'T');
        answer.append((map.get('C')>=map.get('F'))?'C':'F');
        answer.append((map.get('J')>=map.get('M'))?'J':'M');
        answer.append((map.get('A')>=map.get('N'))?'A':'N');
        
        return answer.toString();
    }
}