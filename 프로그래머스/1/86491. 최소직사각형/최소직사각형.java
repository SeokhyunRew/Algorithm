class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        // 각 명함의 가로와 세로를 정리
        for (int[] size : sizes) {
            int w = Math.max(size[0], size[1]); // 큰 값을 가로로
            int h = Math.min(size[0], size[1]); // 작은 값을 세로로

            // 현재까지의 최대값 갱신
            maxWidth = Math.max(maxWidth, w);
            maxHeight = Math.max(maxHeight, h);
        }

        // 지갑의 크기 계산
        return maxWidth * maxHeight;
    }
}
