import java.util.*;
class Solution {
    public int solution(String before, String after) {
        char[] before_array = before.toCharArray();
        char[] after_array = after.toCharArray();
        
        Arrays.sort(before_array);
        Arrays.sort(after_array);
        
        return (Arrays.equals(before_array, after_array))?1:0;
    }
}