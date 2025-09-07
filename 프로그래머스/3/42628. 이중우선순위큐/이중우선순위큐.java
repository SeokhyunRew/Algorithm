import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String s : operations) {
            String[] curr = s.split(" ");
            String command = curr[0];
            int num = Integer.parseInt(curr[1]);
            
            if (command.equals("I")) {
                minHeap.offer(num);
                maxHeap.offer(num);
            } else {
                if (num == 1) { // 최댓값 삭제
                    if (!maxHeap.isEmpty()) {
                        int max = maxHeap.poll();
                        minHeap.remove(max); // 반대쪽 힙에서도 제거
                    }
                } else { // 최솟값 삭제
                    if (!minHeap.isEmpty()) {
                        int min = minHeap.poll();
                        maxHeap.remove(min);
                    }
                }
            }
        }
        
        if (minHeap.isEmpty() || maxHeap.isEmpty()) {
            return new int[]{0, 0};
        } else {
            answer[0] = maxHeap.peek(); // 최댓값
            answer[1] = minHeap.peek(); // 최솟값
        }
        
        return answer;
    }
}
