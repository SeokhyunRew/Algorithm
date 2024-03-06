import java.util.*;

/**
 * [PGS] 여행 경로 / LV3
 */
public class PGS_Travel {
    public static void main(String[] args) {
        String[][] qu = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        Solution solution = new Solution();
        String[] str = solution.solution(qu);

        System.out.println(Arrays.toString(str));
    }
}

class Solution {
    static Map<String, PriorityQueue<String>> map;
    static ArrayList<String> answer = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        map = new HashMap<>();

        for (String[] ticket : tickets) {
            //if(map.get(ticket[0]) == null) map.put(ticket[0], new PriorityQueue<>())
            //map.get(ticket[0]).add(ticket[1]) 과 같음
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>())
                    .add(ticket[1]);
        }

        DFS("ICN");

        return answer.toArray(new String[0]);
    }

    private void DFS(String start) {
        PriorityQueue<String> pq = map.get(start);
        while (pq != null && !pq.isEmpty()) {
            DFS(pq.poll());
        }
        answer.add(0, start);
    }
}