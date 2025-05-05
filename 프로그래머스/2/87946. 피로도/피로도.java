class Solution {
    int answer = -1;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(k, 0, dungeons, visited);
        
        return answer;
    }
    
    private void dfs(int k, int count, int[][] dungeons, boolean[] visited){
        boolean canGo=false;
        
        for(int i=0; i<dungeons.length; i++){
            int atLeastK=dungeons[i][0];
            int after=dungeons[i][1];
            
            if(k>=atLeastK&&k-after>0&&!visited[i]){
                visited[i]=true;
                canGo=true;
                dfs(k-after, count+1, dungeons, visited);
                visited[i]=false;
            } 
        }
        
        if(!canGo){
            answer=Math.max(answer, count);
            return;
        }
    }
    
}