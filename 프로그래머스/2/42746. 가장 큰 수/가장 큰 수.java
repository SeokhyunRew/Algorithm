import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder temp = new StringBuilder();
        List<Integer> arr = new ArrayList<>();
        
        for(int num : numbers) arr.add(num);
        
         Collections.sort(arr, (a, b) -> {
            String sa = String.valueOf(a);
            String sb = String.valueOf(b);

            return (sb+sa).compareTo(sa+sb);

        });
        
        for(int num : arr) temp.append(num);
        
        if(temp.charAt(0) == '0') return "0";
        
        return temp.toString();
    }
}