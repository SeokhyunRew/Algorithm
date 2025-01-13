import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<String, Integer> map = new HashMap<>();
        int temp = 0;

        for (String c : s.split("")) {
            if (map.containsKey(c)) { 
                answer[temp] = temp - map.get(c); 
            } else {
                answer[temp] = -1;
            }
            map.put(c, temp); 
            temp++;
        }

        return answer;
    }
}
