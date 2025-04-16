import java.util.List;
import java.util.ArrayList;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        List<List<Integer>> network = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        
        for(int i=0; i<n; i++) network.add(new ArrayList<>());
        
        for(int i=1; i<=n; i++){
            if(visited[i]) continue;
            visited = dfs(computers, visited, i, n);
            answer++;
        }
        
        return answer;
    }
    
    private boolean[] dfs(int[][] computers,boolean[] visited, int node, int n){
        visited[node]=true;
        
        for(int i=0; i<n; i++){
            if(i==node-1) continue;
            if(computers[node-1][i]==1&&!visited[i+1]) dfs(computers, visited, i+1, n);
        }
        
        return visited;
    }
    
}