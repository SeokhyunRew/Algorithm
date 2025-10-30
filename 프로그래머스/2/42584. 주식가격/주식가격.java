import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        for(int i=0; i<prices.length; i++){
            int curr = prices[i];
            
            queue.offer(new int[] {prices[i], i});
            
            while(queue.peek()[0]>curr){
                int[] arr = queue.poll();
                answer[arr[1]] = i-arr[1];
            }      
        }
        
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            answer[arr[1]] = prices.length-1-arr[1];
        }
        
        return answer;
    }
}