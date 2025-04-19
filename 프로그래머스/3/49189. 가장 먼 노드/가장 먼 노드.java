import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 1) 그래프 생성 (무향 인접 리스트)
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] e : edge) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 2) BFS로 1번 노드부터 각 노드까지 최단 거리 계산
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        dist[1] = 0;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph.get(curr)) {
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    queue.offer(next);
                }
            }
        }

        // 3) 최댓값 거리 찾기
        int maxDist = 0;
        for (int i = 2; i <= n; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
            }
        }

        // 4) 최댓값 거리인 노드 개수 세기
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (dist[i] == maxDist) {
                answer++;
            }
        }

        return answer;
    }
}
