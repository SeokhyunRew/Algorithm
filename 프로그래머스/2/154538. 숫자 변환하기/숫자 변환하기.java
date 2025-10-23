import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.offer(new int[] {x, 0});
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int curr_num = curr[0];
            int curr_count = curr[1];
            
            if(curr_num == y) return curr_count;
            else if(curr_num > y) continue;
            
            if(!visited.contains(curr_num+n)){
                visited.add(curr_num+n);
                queue.offer(new int[] {curr_num+n, curr_count+1});
            }
            
            if(!visited.contains(curr_num*2)){
                visited.add(curr_num+n);
                queue.offer(new int[] {curr_num*2, curr_count+1});
            }
            
            if(!visited.contains(curr_num*3)){
                visited.add(curr_num+n);
                queue.offer(new int[] {curr_num*3, curr_count+1});
            }
        }
        
        return -1;
    }
}