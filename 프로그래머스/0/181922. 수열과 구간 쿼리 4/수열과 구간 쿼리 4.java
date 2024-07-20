class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int low;
        int high;
        int temp;

        for (int i = 0; i < queries.length; i++) {
            low = queries[i][0];
            high = queries[i][1];
            temp = queries[i][2];
            for (int j = low; j <= high; j++) {
                if(j%temp==0 || j==0){
                    arr[j] += 1;
                }
            }
        }
        return arr;
    }
}