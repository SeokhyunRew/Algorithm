import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int num : scoville) queue.add(num);
        
        while(queue.size() > 1 && queue.peek()<K){
            queue.add(queue.poll()+queue.poll()*2);
            answer++;
        }
        
        return queue.peek() >= K ? answer : -1;
    }
}
