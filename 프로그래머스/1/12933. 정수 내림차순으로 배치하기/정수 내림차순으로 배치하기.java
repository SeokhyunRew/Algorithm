import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String temp = String.valueOf(n);
        Integer[] array = new Integer[temp.length()];
        int index = 0;
        StringBuilder sb = new StringBuilder();
        
        for(char ch : temp.toCharArray()){
            array[index] = ch - '0';
            index ++;
        }
        
        Arrays.sort(array, Collections.reverseOrder());
        
        for(int num : array){
            sb.append(num);
        }
        
        return Long.parseLong(sb.toString());
    }
}