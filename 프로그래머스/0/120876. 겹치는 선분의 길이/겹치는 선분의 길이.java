import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<lines.length; i++){
            for(int j=lines[i][0]+1; j<=lines[i][1]; j++){
                sb.setLength(0);
                sb.append(j-1);
                sb.append(j);
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            }
        }    
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) answer++;
        }
        
        return answer;
    }
}