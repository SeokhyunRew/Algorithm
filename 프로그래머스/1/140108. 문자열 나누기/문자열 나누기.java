class Solution {
    public int solution(String s) {
        int answer = 0;
        int same = 0, diff = 0;
        char x = s.charAt(0);  // 첫 문자 기준

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (same == 0) {
                x = c; // 새 기준 문자 설정
            }

            if (c == x) same++;
            else diff++;

            if (same == diff) {
                answer++;
                same = 0;
                diff = 0;
            }
        }

        // 만약 끝까지 갔는데 same != diff 라면 마지막 덩어리 추가
        if (same != 0 || diff != 0) {
            answer++;
        }

        return answer;
    }
}
