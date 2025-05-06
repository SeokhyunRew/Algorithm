import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[] {0,0,1});
        
        while(!queue.isEmpty()){
            
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int move = curr[2];
            
            if(currX==n-1 && currY==m-1) return move;
            
            for(int i=0; i<4; i++){
                int newX = currX+dx[i];
                int newY = currY+dy[i];
                
                if(newX>=0 &&
                   newX<n &&
                   newY>=0 &&
                   newY<m &&
                   maps[newX][newY]!=0){
                    maps[newX][newY] = 0; // 방문 처리
                    queue.offer(new int[] {currX+dx[i], currY+dy[i], move+1});
                } 
            }
        }
        return -1;
    }
}