class Solution {
    public int solution(String[] arr) {
        int n = (arr.length + 1) / 2; // 숫자의 개수
        int[] nums = new int[n];
        String[] ops = new String[n-1];

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) nums[i/2] = Integer.parseInt(arr[i]);
            else ops[i/2] = arr[i];
        }

        int[][] dpMax = new int[n][n];
        int[][] dpMin = new int[n][n];

        // 초기화 (자기 자신)
        for (int i = 0; i < n; i++) {
            dpMax[i][i] = nums[i];
            dpMin[i][i] = nums[i];
        }

        // 구간 길이
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dpMax[i][j] = Integer.MIN_VALUE;
                dpMin[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    String op = ops[k];
                    if (op.equals("+")) {
                        dpMax[i][j] = Math.max(dpMax[i][j], dpMax[i][k] + dpMax[k+1][j]);
                        dpMin[i][j] = Math.min(dpMin[i][j], dpMin[i][k] + dpMin[k+1][j]);
                    } else { // "-"
                        dpMax[i][j] = Math.max(dpMax[i][j], dpMax[i][k] - dpMin[k+1][j]);
                        dpMin[i][j] = Math.min(dpMin[i][j], dpMin[i][k] - dpMax[k+1][j]);
                    }
                }
            }
        }

        return dpMax[0][n-1];
    }
}
