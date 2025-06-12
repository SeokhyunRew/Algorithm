import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        // 첫 번째 구간
        int a1 = intervals[0][0];
        int b1 = intervals[0][1];
        // 두 번째 구간
        int a2 = intervals[1][0];
        int b2 = intervals[1][1];

        // 결과 길이 계산
        int totalLength = (b1 - a1 + 1) + (b2 - a2 + 1);
        int[] result = new int[totalLength];
        int index = 0;

        // 첫 번째 구간 복사
        for (int i = a1; i <= b1; i++) {
            result[index++] = arr[i];
        }

        // 두 번째 구간 복사
        for (int i = a2; i <= b2; i++) {
            result[index++] = arr[i];
        }

        return result;
    }
}
