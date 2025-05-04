import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> buyMap = new HashMap<>();
        int n = discount.length;

        // 초기 10일간의 상품 구성
        for (int i = 0; i < 10; i++) {
            buyMap.put(discount[i], buyMap.getOrDefault(discount[i], 0) + 1);
        }

        for (int i = 0; i <= n - 10; i++) {
            // 현재 윈도우가 조건을 만족하는지 검사
            boolean canJoin = true;
            for (int k = 0; k < want.length; k++) {
                if (buyMap.getOrDefault(want[k], 0) < number[k]) {
                    canJoin = false;
                    break;
                }
            }

            if (canJoin) answer++;

            // 슬라이딩 윈도우 이동: i일 제거, i+10일 추가
            if (i + 10 < n) {
                String out = discount[i];
                String in = discount[i + 10];

                // 제거
                buyMap.put(out, buyMap.get(out) - 1);
                if (buyMap.get(out) == 0) buyMap.remove(out); // 깔끔하게 삭제

                // 추가
                buyMap.put(in, buyMap.getOrDefault(in, 0) + 1);
            }
        }

        return answer;
    }
}
