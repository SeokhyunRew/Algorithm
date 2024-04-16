import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int temp;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num : works){
            maxHeap.offer(num);
        }
        
        for(int i=0; i<n; i++){
            temp = maxHeap.poll();
            if(temp==0){
                return 0;
            }
            temp --;
            maxHeap.offer(temp);
        }
        
        while (!maxHeap.isEmpty()) {
            answer += Math.pow(maxHeap.poll(),2);
        }
        
        return answer;
    }
}