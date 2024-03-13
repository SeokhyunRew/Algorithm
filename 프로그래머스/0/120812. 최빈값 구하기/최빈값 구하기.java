import java.util.*;

class Solution {
    public int solution(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        int count = 0;
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int num:array) {
            set.add(num);
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }

        for (int num: set) {
            if(map.get(num) > maxValue){
                maxValue = map.get(num);
                count = 1;
                answer = num;
            } else if(map.get(num) == maxValue){
                count ++;
            }
        }

        return (count == 1)? answer:-1;
    }
}
