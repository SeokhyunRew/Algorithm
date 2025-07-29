import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String s : completion) map.put(s, map.getOrDefault(s, 0)+1);
        
        for(String s : participant){
            if(!map.containsKey(s)) return s;  
            else{
                if(map.get(s)==0) return s;
                map.put(s, map.getOrDefault(s, 0)-1);
            }
        }
        
        return "";
    }
}