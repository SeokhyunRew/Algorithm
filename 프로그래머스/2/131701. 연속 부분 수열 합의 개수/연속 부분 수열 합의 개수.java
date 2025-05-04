import java.util.Set;
import java.util.HashSet;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int temp=0;
        int arrLen=elements.length;
        
        for(int i=0; i<arrLen; i++){
            for(int j=1; j<arrLen; j++){
                temp=0;
                for(int k=0; k<j; k++){
                    temp+=elements[(i + k) % arrLen];
                }
                set.add(temp);
            }   
        }
        
        temp=0;
        
        for(int i=0; i<arrLen; i++) temp+=elements[i];
        set.add(temp);
        
        return set.size();
    }
}