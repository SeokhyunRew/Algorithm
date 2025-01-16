import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int temp = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<name.length; i++){
           map.put(name[i], yearning[i]); 
        }
        
        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                if(map.containsKey(photo[i][j])) temp+=map.get(photo[i][j]);    
            }
            answer[i] = temp;
            temp = 0;
        }
        
        return answer;
    }
}