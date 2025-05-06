import java.util.*;

class Solution {
    int maxSheep = 0;
    int[] info;
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public int solution(int[] info, int[][] edges) {
        this.info = info;

        // 그래프 생성
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<Integer>());
            }
            graph.get(from).add(to);
        }

        List<Integer> nextNodes = new ArrayList<Integer>();
        nextNodes.add(0); // 시작 노드 0부터
        dfs(0, 0, nextNodes);

        return maxSheep;
    }

    private void dfs(int sheep, int wolf, List<Integer> nextNodes) {
        for (int i = 0; i < nextNodes.size(); i++) {
            int curr = nextNodes.get(i);

            int newSheep = sheep;
            int newWolf = wolf;

            if (info[curr] == 0) newSheep++;
            else newWolf++;

            if (newWolf >= newSheep) continue;

            if (newSheep > maxSheep) maxSheep = newSheep;

            List<Integer> newNext = new ArrayList<Integer>();
            for (int j = 0; j < nextNodes.size(); j++) {
                if (j != i) newNext.add(nextNodes.get(j));
            }

            if (graph.containsKey(curr)) {
                List<Integer> children = graph.get(curr);
                for (int j = 0; j < children.size(); j++) {
                    newNext.add(children.get(j));
                }
            }

            dfs(newSheep, newWolf, newNext);
        }
    }
}
