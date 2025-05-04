import java.util.Map;
import java.util.HashMap;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        boolean canJoin;
        Map<String, Integer> wantMap = new HashMap<>();
        
        for(int i=0; i<number.length; i++) wantMap.put(want[i], number[i]);
        
        for(int i=0; i<=discount.length-10; i++){
            Map<String, Integer> buyMap = new HashMap<>();
            canJoin = true;
            for(int j=0; j<10; j++) buyMap.put(discount[j+i], buyMap.getOrDefault(discount[j+i], 0)+1);
            for(int k=0; k<want.length; k++){
                if(buyMap.getOrDefault(want[k],0) < wantMap.get(want[k])) canJoin=false;
            }
            if(canJoin) answer++;
        }
        
        return answer;
    }
}