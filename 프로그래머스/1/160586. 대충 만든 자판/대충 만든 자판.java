import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int index;
        HashMap<Character, Integer> dictionary = new HashMap<>();
        
        for(int i=0; i<26; i++){
            dictionary.put((char)('A'+i), 0);
        }
        
        for(int i=0; i<keymap.length; i++){
            index = 0;
            for(char c : keymap[i].toCharArray()){
                index++;
                if(dictionary.get(c)>index||dictionary.get(c)==0) dictionary.put(c, index);    
            }
        }
      
        for(int i=0; i<targets.length; i++){
            index = 0;
            for(char c : targets[i].toCharArray()){
                if(dictionary.get(c)==0){
                    index=-1;
                    break;
                }
                index += dictionary.get(c);
            }
            answer[i] = index;
        }
        
        return answer;
    }
}