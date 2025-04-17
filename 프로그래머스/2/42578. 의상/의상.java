import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String[] s : clothes){
            String category=s[1];
            String clothe=s[0];
            if(map.containsKey(category)) map.get(category).add(clothe);
            else{
                map.put(category, new ArrayList<String>());
                map.get(category).add(clothe);
            }
        }
        
        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
            answer *= entry.getValue().size()+1;
        }
        
        return answer-1;
    }
}