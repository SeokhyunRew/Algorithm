import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] str : clothes) map.put(str[1], map.getOrDefault(str[1], 0)+1);
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) answer *= entry.getValue()+1;
        
        return answer-1;
    }
}