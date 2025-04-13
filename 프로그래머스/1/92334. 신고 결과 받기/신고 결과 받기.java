import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashSet<String> set = new HashSet<>();
        
        HashMap<String, Integer> count_map = new HashMap<>();
        HashMap<String, Integer> report_map = new HashMap<>();
        
        String give;
        String take;
        String[] temp;
        
        for(String s : report) set.add(s);
        
        for(String item : set){
            temp = item.split(" ");
            take = temp[1];
            
            count_map.put(take, count_map.getOrDefault(take, 0)+1);
        }
        
        for(String item : set){
            temp = item.split(" ");
            give = temp[0];
            take = temp[1];
            
            if(count_map.get(take)>=k){
                report_map.put(give, report_map.getOrDefault(give, 0)+1);
            }
        }
        
        
        for(int i=0; i<id_list.length; i++) answer[i] = report_map.getOrDefault(id_list[i], 0);
        
        
        return answer;
    }
}