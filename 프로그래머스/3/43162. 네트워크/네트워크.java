import java.util.*;

class Solution {
    static int count = 0;
    static List<Integer> tempList = new ArrayList<>();
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            tempList.add(i);
        }

        for (int j = 0; j < computers.length; j++) {
            if (!visited[j]) {
                bfs(computers, j);
                count++;
            }
        }
        return count;
    }
    
    public static void bfs(int[][] computers, int node){
        visited[node] = true;

        for (int i = 0; i < computers[node].length; i++) {
            if (computers[node][i] == 1 && !visited[i]) {
                bfs(computers, i);
            }
        }
    }
}