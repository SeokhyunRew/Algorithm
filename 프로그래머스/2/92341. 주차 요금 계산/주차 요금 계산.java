import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, Integer> time = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>();
        
        for(String str : records){
            String[] curr=str.split(" ");
            int curr_num = Integer.valueOf(curr[1]);
            if(curr[2].equals("IN")) map.put(curr_num, curr[0]);
            else{
                time.put(curr_num, calculateTime(map.get(curr_num), curr[0])+time.getOrDefault(curr_num, 0));
                map.remove(curr_num);
            }
        }
        
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            int curr_num = entry.getKey();
            String start = entry.getValue();
            time.put(curr_num, calculateTime(start, "23:59")+time.getOrDefault(curr_num, 0));
        }
        
        for(Map.Entry<Integer, Integer> entry : time.entrySet()){
            time.put(entry.getKey(), calculateFee(entry.getValue(), fees));
            queue.add(entry.getKey());
        }
        
        int[] answer = new int[time.size()];
        int index = 0;
        
        while(!queue.isEmpty()){
            answer[index] = time.get(queue.poll());
            index++;
        }
        
        return answer;
    }
    
    private int calculateTime(String start, String end){
        String[] start_arr = start.split(":"); 
        String[] end_arr = end.split(":");
        int start_value = Integer.valueOf(start_arr[0])*60+Integer.valueOf(start_arr[1]);
        int end_value = Integer.valueOf(end_arr[0])*60+Integer.valueOf(end_arr[1]);
        
        return end_value-start_value;
    }
    
    private int calculateFee(int time, int[] fees){
        int FIX_TIME = fees[0];
        int FIX_FEE = fees[1];
        int PER_MINUTE = fees[2];
        int PER_FEE = fees[3];
        
        if(time<FIX_TIME) return FIX_FEE;
        else return FIX_FEE+ (int) Math.ceil((double) (time-FIX_TIME)/PER_MINUTE)*PER_FEE;
    }
}