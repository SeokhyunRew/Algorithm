import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        if(nums.length/2>set.size()) return set.size();
        else return nums.length/2;
        
    }
}