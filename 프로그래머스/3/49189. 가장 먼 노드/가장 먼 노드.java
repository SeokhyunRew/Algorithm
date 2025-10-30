import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        int[] keep = new int[n+1];
        int max = 0;
        
        for(int[] node : edge){
            int node1 = node[0];
            int node2 = node[1];
            
            if(!map.containsKey(node1)) map.put(node1, new ArrayList<>());
            if(!map.containsKey(node2)) map.put(node2, new ArrayList<>());
            
            map.get(node1).add(node2);
            map.get(node2).add(node1);
        }
        
        queue.offer(new int[] {1, 0});
        set.add(1);
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int num = curr[0];
            int depth = curr[1];
            
            for(int next : map.get(num)){
                if(!set.contains(next)){
                    keep[next] = depth+1;
                    set.add(next);
                    queue.offer(new int[] {next, depth+1});
                }
            }
        }
        
        for(int num : keep) max=(num>max)?num:max;
        for(int num : keep) if(num==max) answer++;
        
        return answer;
    }
}