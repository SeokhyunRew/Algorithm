class Solution {
    public int[] solution(int[] arr) {
        int temp = 0;
        
        for(int i=0; i<arr.length; i++){
            temp += arr[i];
        }
        
        int[] answer = new int[temp];
        int index = 0;
        
        for(int i=0; i<arr.length; i++){
            for(int j=index; j<index+arr[i]; j++){
                answer[j] = arr[i];
            }
            index += arr[i];
        }
        
        return answer;
    }
}