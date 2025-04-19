import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]}); // [index, priority]
        }

        Arrays.sort(priorities); // 오름차순 정렬
        int priorityIndex = priorities.length - 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int idx = curr[0];
            int pri = curr[1];

            if (pri == priorities[priorityIndex]) {
                answer++;
                priorityIndex--;

                if (idx == location) break;
            } else {
                queue.add(curr); // 우선순위 낮으면 뒤로
            }
        }

        return answer;
    }
}
