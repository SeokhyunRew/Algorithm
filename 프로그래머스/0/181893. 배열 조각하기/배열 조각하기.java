import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int start = 0;
        int end = arr.length;

        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                // 짝수 인덱스: query[i] 뒤를 자름 (query[i] 포함)
                end = start + query[i] + 1;
            } else {
                // 홀수 인덱스: query[i] 앞을 자름 (query[i] 포함 안함)
                start = start + query[i];
            }
        }

        // 결과 배열 만들기
        return Arrays.copyOfRange(arr, start, end);
    }
}
