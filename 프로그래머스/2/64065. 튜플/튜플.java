import java.util.*;
class Solution {
    public int[] solution(String s) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int length = stringToMap(s, map);
        
        int[] answer = new int[length];
        
        for(int num : map.get(1)) answer[0] = num;
        
        for(int i=1; i<length; i++){
            for(int num : map.get(i+1)){
                if(!map.get(i).contains(num)) answer[i] = num;
            }
        }
        
        return answer;
    }
    
    private int stringToMap(String s, Map<Integer, Set<Integer>> map){
        int length=0;
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
                if(s.charAt(i+1)==','){
                    set.add(Integer.valueOf(sb.toString()));
                    sb.setLength(0);
                }
                else if(s.charAt(i+1)=='}'){
                    set.add(Integer.valueOf(sb.toString()));
                    sb.setLength(0);
                    map.put(set.size(), new HashSet<>(set));
                    length = Math.max(length, set.size());
                    set.clear();
                }
            }   
        }
        
        return length;
    }
    
}