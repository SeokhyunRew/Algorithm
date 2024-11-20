import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>(); 
        
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue()==1) sb.append(entry.getKey());
        }
        
        char[] array = sb.toString().toCharArray();
        Arrays.sort(array);

        return new String(array);
    }
}