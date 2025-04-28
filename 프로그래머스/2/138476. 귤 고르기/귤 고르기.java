import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : tangerine) map.put(num, map.getOrDefault(num, 0)+1);
        
        int[] arr = new int[map.size()];
        int index = 0;
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            arr[index] = entry.getValue();
            index++;
        }
        
        index--;
        Arrays.sort(arr);
        
        while(k>0){
            k -= arr[index];
            answer++;
            index--;
        }
        
        return answer;
    }
}