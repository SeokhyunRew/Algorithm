import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int priIndex = priorities.length-1;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int num : priorities) queue.offer(num);
        
        Arrays.sort(priorities);
        
        while(true){
            if(queue.peek()==priorities[priIndex]){
                queue.poll();
                priIndex--;
                answer++;
                if(location==0) return answer;
                location--;
                continue;
            }
            queue.offer(queue.peek());
            queue.poll();
            if(location==0) location=queue.size()-1;
            else location--;
        }
    }
}