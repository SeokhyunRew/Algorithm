import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;
        
        for(int num : scoville) queue.offer(num);
        
        while(queue.peek()<K){
            if(queue.size()<2) return -1;
            queue.offer(queue.poll()+queue.poll()*2);
            answer++;
        }
        
        return answer;
    }
}
