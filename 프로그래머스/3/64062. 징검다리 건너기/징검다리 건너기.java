import java.util.*;
class Solution {

    public int solution(int[] stones, int k) {
        int min = 200_000_001;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < stones.length; i++) {
            // 현재 돌보다 값이 작거나 같은 인덱스는 덱 뒤에서 제거
            while (!dq.isEmpty() && stones[dq.peekLast()] <= stones[i]) dq.pollLast();
            dq.addLast(i);

            // 윈도우를 벗어난 인덱스는 앞에서 제거
            if (dq.peekFirst() <= i - k) dq.pollFirst();

            // 윈도우가 완성되었을 때 최소값 후보로 갱신
            if (i >= k - 1) min = Math.min(min, stones[dq.peekFirst()]);
        }

        return min;
    }
}