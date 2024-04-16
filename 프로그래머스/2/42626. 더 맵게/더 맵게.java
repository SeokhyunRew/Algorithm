import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int mini;
        int next_mini;
        int temp;
        int answer = 0;

        // PriorityQueue 생성 (기본값: 최소 힙)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 배열의 모든 요소를 힙에 추가
        for (int num : scoville) {
            minHeap.offer(num); // offer() 메서드를 사용하여 요소를 추가
        }
        
        while(minHeap.peek() < K){
            if(minHeap.size() < 2){
            return -1;
        }
            mini = minHeap.poll();
            next_mini = minHeap.poll();
            temp = mini + next_mini*2;
            minHeap.offer(temp);
            answer ++;
        }
        
        return answer;
    }
}