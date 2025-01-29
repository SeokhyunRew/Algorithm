import java.util.*;
class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = Arrays.copyOf(arr, arr.length);
        
        if(arr.length%2==1){
            for(int i=0; i<arr.length; i++){
                if(i%2==0) answer[i] += n;
            }
        }else{
            for(int j=0; j<arr.length; j++){
                if(j%2==1) answer[j] += n;
            }
        }
        
        return answer;
    }
}