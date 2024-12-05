import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> array = new ArrayList<>();
        int index=0;
        
        while(index<arr.length){
            if(array.size()==0){
                array.add(arr[index]);
                index++;
            }
            else if(array.get(array.size()-1)<arr[index]){
                array.add(arr[index]);
                index++;
            }
            else array.remove(array.size()-1);
        }
        
        int[] stk = new int[array.size()];
        for(int i=0; i<array.size(); i++){
            stk[i] = array.get(i);
        }
        
        return stk;
    }
}