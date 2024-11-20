import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>(); 
        
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(char key : map.keySet()){
            if(map.get(key)==1) sb.append(key);
        }
        
        char[] array = sb.toString().toCharArray();
        Arrays.sort(array);

        return new String(array);
    }
}