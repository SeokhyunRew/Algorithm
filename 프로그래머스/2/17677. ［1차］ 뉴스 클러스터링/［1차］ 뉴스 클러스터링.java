import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int up = 0;
        int down = 0;
        int FIX_VALUE = 65536;
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(char c : str1.toCharArray()){
            if(Character.isLetter(c)) sb.append(Character.toLowerCase(c));
            else sb.setLength(0);
            
            if(sb.length()==2){
                map1.put(sb.toString(), map1.getOrDefault(sb.toString(), 0)+1);
                sb.deleteCharAt(0);
            }
        } 
        
        sb.setLength(0);
        
        for(char c : str2.toCharArray()){
            if(Character.isLetter(c)) sb.append(Character.toLowerCase(c));
            else sb.setLength(0);
            
            if(sb.length()==2){
                map2.put(sb.toString(), map2.getOrDefault(sb.toString(), 0)+1);
                sb.deleteCharAt(0);
            }
        } 
        
        for(Map.Entry<String, Integer> entry : map1.entrySet()){
            if(map2.containsKey(entry.getKey())){
                up += Math.min(map2.get(entry.getKey()), entry.getValue());
                down += Math.max(map2.get(entry.getKey()), entry.getValue());
            }else down += entry.getValue();
        }
        
        for(Map.Entry<String, Integer> entry : map2.entrySet()) if(!map1.containsKey(entry.getKey())) down += entry.getValue();
        
        return (down==0)?FIX_VALUE:up*FIX_VALUE/down;
    }
}