import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<topping.length; i++){
            int curr = topping[i];
            set2.add(curr);    
            map.put(curr, map.getOrDefault(curr, 0)+1);
        }
        
        for(int i=0; i<topping.length; i++){
            int curr = topping[i];
            set1.add(curr);
            map.put(curr, map.getOrDefault(curr, 0)-1);
            if(map.get(curr)<=0) set2.remove(curr);
            if(set1.size()==set2.size()) answer++;
        }
        
        return answer;
    }
}