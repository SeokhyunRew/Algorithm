import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int xlen = maps.length;
        int ylen = maps[0].length;
        boolean[][] visited = new boolean[xlen][ylen];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[] {0,0,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];
            
            if(x==xlen-1 && y==ylen-1) return dist;
            
            for(int i=0; i<4; i++){
                if(x+dx[i] >= 0 &&
                   x+dx[i] < xlen &&
                   y+dy[i] >= 0 &&
                   y+dy[i] < ylen &&
                   maps[x+dx[i]][y+dy[i]] != 0 &&
                   !visited[x+dx[i]][y+dy[i]]){
                    visited[x+dx[i]][y+dy[i]] = true;
                    queue.offer(new int[] {x+dx[i], y+dy[i], dist+1});
                }
            }
        }
        
        return -1;
    }
}