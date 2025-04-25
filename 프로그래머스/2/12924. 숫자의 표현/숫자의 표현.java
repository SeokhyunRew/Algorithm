class Solution {
    public int solution(int n) {
        int count = 0;      // 표현 방법의 수
        int sum = 0;        // 현재 구간의 합
        int left = 1, right = 1;

        // left가 n까지 옮겨지면 모든 구간을 검사한 것
        while (left <= n) {
            if (sum < n && right <= n) {
                // sum이 부족하면 오른쪽 끝을 확장
                sum += right;
                right++;
            } else {
                // sum이 n 이상이거나 더 이상 확장할 수 없으면
                if (sum == n) {
                    count++;  // 정확히 n이 되는 구간 찾음
                }
                // 왼쪽 끝을 한 칸 줄여 합을 조정
                sum -= left;
                left++;
            }
        }

        return count;
    }
}
