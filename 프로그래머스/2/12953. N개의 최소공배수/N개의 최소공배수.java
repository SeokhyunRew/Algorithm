import java.util.*;
class Solution {
    public int solution(int[] arr) {
        boolean check = true;
        int index = 1;
        
        Arrays.sort(arr);
        
        int temp = arr[arr.length-1];
        
        
        while(check){
            for(int i=0; i<arr.length; i++){
                if((temp*index)%arr[i] != 0) break;
                if(i==arr.length-1) check = false;
            }
            index++;
        }
        
        return temp*(index-1);
    }
}