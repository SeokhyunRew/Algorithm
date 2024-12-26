class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        if (arr.length==1){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }else {
            answer = new int[arr.length-1];
        }
        
        int min = Integer.MAX_VALUE;
        int temp = 0;
        
        for(int i=0; i<arr.length; i++){
            if (arr[i]<min) min=arr[i];
        }
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]==min){
                continue;    
            }
            answer[temp] = arr[i];
            temp ++;
        }
        
        return answer;
    }
}