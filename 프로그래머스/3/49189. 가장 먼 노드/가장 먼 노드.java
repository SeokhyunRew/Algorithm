import java.util.*;

public class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 인접 리스트 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        // 방문 여부 배열 및 거리 배열 초기화
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        
        // BFS 수행
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 시작 노드는 1번 노드
        visited[1] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        
        // 최단 경로 중에서 가장 긴 거리 계산
        int maxDistance = 0;
        for (int dist : distance) {
            maxDistance = Math.max(maxDistance, dist);
        }
        
        // 가장 긴 거리를 가진 노드의 수 계산
        for (int dist : distance) {
            if (dist == maxDistance) {
                answer++;
            }
        }
        
        return answer;
    }
}
