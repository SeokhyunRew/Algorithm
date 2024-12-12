import java.util.*;
class Solution {
    public int[] solution(int n, int k) {
        // 결과를 저장할 리스트 생성
        List<Integer> multiples = new ArrayList<>();

        // k의 배수를 구해서 리스트에 추가
        for (int i = k; i <= n; i += k) {
            multiples.add(i);
        }

        // 리스트를 배열로 변환하여 반환
        return multiples.stream().mapToInt(Integer::intValue).toArray();
    }
}