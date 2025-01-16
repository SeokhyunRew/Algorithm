import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        if(k>=score.length){
            
            for(int i=0; i<score.length; i++){
                minHeap.add(score[i]);
                answer[i] = minHeap.peek();
            }
            return answer;
            
        }else{
            for(int i=0; i<k; i++){
                minHeap.add(score[i]);
                answer[i] = minHeap.peek();
            }
        }
        
        for(int j=k; j<score.length; j++){
            if(minHeap.peek()<score[j]){
                minHeap.poll();
                minHeap.add(score[j]);
            }
            answer[j] = minHeap.peek();
        }
        
        return answer;
    }
}