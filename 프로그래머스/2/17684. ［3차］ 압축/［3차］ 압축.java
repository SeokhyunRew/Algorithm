import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<Integer> arr = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder(msg);
        int index=1;
        int dicIndex=26;
        
        for(int i=0; i<dicIndex; i++) map.put(String.valueOf((char) ('A'+i)), i+1);
        
        while(sb.length()!=0){
            
            // index가 sb 길이보다 크면 조정
            if (index > sb.length()) {
                arr.add(map.get(sb.substring(0, sb.length())));
                break;
            }
            
            if(map.containsKey(sb.substring(0,index))) index++;
            else{
                arr.add(map.get(sb.substring(0,index-1)));
                dicIndex++;
                map.put(sb.substring(0,index), dicIndex);
                sb=sb.delete(0,index-1);
                index=1;
            }
        }
        
        int[] answer = new int[arr.size()];
        for(int i=0; i<answer.length; i++) answer[i] = arr.get(i);
        
        return answer;
    }
}