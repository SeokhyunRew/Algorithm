class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;

        while (a != b) {
            a = (a + 1) / 2;  // 다음 라운드 번호 계산
            b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }
}
