import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];
            
            if(x==n-1 && y==m-1) return dist;
            
            for(int i=0; i<dx.length; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if(nx>=0&&
                   ny>=0&&
                   nx<n&&
                   ny<m&&
                   maps[nx][ny]==1&&
                   !visited[nx][ny]){
                    
                    visited[nx][ny]=true;
                    queue.offer(new int[] {nx,ny,dist+1});
                    
                }
            }
        }
        
        return -1;
    }
}