class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] temp;
        int num;

        for (int i=0; i < queries.length ; i++){
            temp = queries[i];
            num = arr[temp[0]];
            arr[temp[0]] = arr[temp[1]];
            arr[temp[1]] = num;
        }
        
        return arr;
    }
}