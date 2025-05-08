import java.util.*;

class Solution {
    int answer = 0;
    int[][] qArr;
    int[] ansArr;

    public int solution(int n, int[][] q, int[] ans) {
        qArr = q;
        ansArr = ans;

        // 1~n에서 5개를 선택하는 조합을 백트래킹으로 찾음
        dfs(1, n, new ArrayList<>());

        return answer;
    }

    // 1~n 중 5개 뽑는 조합 생성
    private void dfs(int start, int n, List<Integer> curr) {
        if (curr.size() == 5) {
            if (isValid(curr)) answer++;
            return;
        }

        for (int i = start; i <= n; i++) {
            curr.add(i);
            dfs(i + 1, n, curr);
            curr.remove(curr.size() - 1);
        }
    }

    // 현재 조합 curr이 모든 힌트를 만족하는지 확인
    private boolean isValid(List<Integer> curr) {
        for (int i = 0; i < qArr.length; i++) {
            int match = 0;
            for (int val : qArr[i]) {
                if (curr.contains(val)) match++;
            }
            if (match != ansArr[i]) return false;
        }
        return true;
    }
}
