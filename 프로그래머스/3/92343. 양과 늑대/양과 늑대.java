import java.util.*;
class Solution {
    int answer = 1;
    int[] globalInfo;
    public int solution(int[] info, int[][] edges) {
        globalInfo = info;
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        
        for(int i=0; i<edges.length; i++){
            int from=edges[i][0];
            if(!graph.containsKey(from)) graph.put(from, new ArrayList<Integer>());
            graph.get(from).add(edges[i][1]);
        }
        
        System.out.println(graph);
        dfs(1, 0, graph.get(0), graph);
        
        return answer;
    }
    
    private void dfs(int sheep, int wolf, ArrayList<Integer> needGo, Map<Integer, ArrayList<Integer>> graph){
        for(int i=0; i<needGo.size(); i++){
            int newSheep = sheep;
            int newWolf = wolf;
            int currNode = needGo.get(i);
            
            if(globalInfo[currNode]==0) newSheep++;
            else newWolf++;
            
            if(newWolf>=newSheep) continue;
            if(newSheep>answer) answer=newSheep;
            
            ArrayList<Integer> nextGo = new ArrayList<>();
            
            for(int j=0; j<needGo.size(); j++) if(j!=i) nextGo.add(needGo.get(j));
            
            if(graph.containsKey(currNode)){
                for(int node : graph.get(currNode)) nextGo.add(node);
            }
            
            dfs(newSheep, newWolf, nextGo, graph);
            
        }
    }
}