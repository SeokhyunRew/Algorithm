import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(String gem : gems) set.add(gem);
        for(String gem : set) map.put(gem, 0);
        
        int[] temp = new int[2];
        int start = 0;
        
        for(int i=0; i<gems.length; i++){
            map.put(gems[i], map.get(gems[i])+1);
            if(calculate(map)){
                answer[0]=0; answer[1]=i; temp[0]=0; temp[1]=i;
                start = i+1;
                break;
            }
        }
        
        for(int i=start; i<gems.length; i++){
            while(temp[0]<=temp[1]){
                if(map.get(gems[temp[0]]) > 1){
                    map.put(gems[temp[0]], map.get(gems[temp[0]])-1);
                    temp[0]++;
                }else break;
            }
            if((temp[1]-temp[0]) < (answer[1]-answer[0])){
                answer[0]=temp[0];
                answer[1]=temp[1];
            }
            temp[1]++;
            map.put(gems[temp[1]], map.get(gems[temp[1]])+1);
        }
        
        while(temp[0]<=temp[1]){
            if(map.get(gems[temp[0]]) > 1){
                map.put(gems[temp[0]], map.get(gems[temp[0]])-1);
                temp[0]++;
            }else break;
        }
        if((temp[1]-temp[0]) < (answer[1]-answer[0])){
            answer[0]=temp[0];
            answer[1]=temp[1];
        }
        
        answer[0]++;
        answer[1]++;
        
        return answer;
    }
    
    private boolean calculate(Map<String, Integer> map){
        for(Map.Entry<String, Integer> entry : map.entrySet()) if(entry.getValue()==0) return false;
        return true;
    }
}