import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int first = -1;
        int last = -1;

        // 2가 나오는 첫 번째, 마지막 인덱스 찾기
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                if (first == -1) first = i;
                last = i;
            }
        }

        // 2가 없다면 [-1]
        if (first == -1) return new int[]{-1};

        // 부분 배열 생성
        int[] result = Arrays.copyOfRange(arr, first, last + 1);
        return result;
    }
}
