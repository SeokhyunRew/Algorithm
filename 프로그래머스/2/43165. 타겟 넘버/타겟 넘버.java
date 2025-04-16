class Solution {
    int answer = 0; // 클래스 전역 변수로 선언

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    // DFS 함수: 현재 인덱스, 누적합을 받아서 탐색
    private void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        // 현재 숫자를 더하거나
        dfs(numbers, target, depth + 1, sum + numbers[depth]);

        // 현재 숫자를 빼거나
        dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }
}
