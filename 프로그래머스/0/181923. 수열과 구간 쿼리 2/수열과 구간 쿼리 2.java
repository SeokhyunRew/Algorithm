class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int low;
        int high;
        int temp;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[queries.length];

        for (int i=0; i < queries.length ; i++){
            low = queries[i][0];
            high = queries[i][1];
            for (int j = low; j < high+1; j++) {
                temp = arr[j];
                if(temp>queries[i][2]){
                    if(temp<min){
                        min = temp;
                    }
                }
            }
            if(min != Integer.MAX_VALUE){
                answer[i] = min;
            }else{
                answer[i] = -1;
            }
            min = Integer.MAX_VALUE;
        }
        return answer;
    }
}