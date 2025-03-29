import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] temp = new int[n];
        Arrays.fill(temp, 1);

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // lost 처리
        for (int l : lost) temp[l - 1]--;

        // reserve 처리
        for (int r : reserve) temp[r - 1]++;

        // 도난당한 사람 기준으로 좌우 확인
        for (int i = 0; i < n; i++) {
            if (temp[i] == 0) {
                if (i > 0 && temp[i - 1] == 2) {
                    temp[i]++;
                    temp[i - 1]--;
                } else if (i < n - 1 && temp[i + 1] == 2) {
                    temp[i]++;
                    temp[i + 1]--;
                }
            }
        }

        int answer = 0;
        for (int t : temp) {
            if (t >= 1) answer++;
        }
        return answer;
    }
}
