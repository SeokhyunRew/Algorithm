import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
        
        int[] temp = new int[2];
        int index=0;
        boolean double2 = false;
        int[] array = {a, b, c, d};
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<array.length; i++){
            map.put(array[i],  map.getOrDefault(array[i], 0)+1);
        }
        
        if(map.size()==1) return 1111*a;
        else if(map.size()==2){
            
            for(Map.Entry<Integer, Integer> entryset : map.entrySet()){
                if(entryset.getValue()==2){
                    temp[index] = entryset.getKey();
                    index++;
                    double2 = true; 
                }
                else if(entryset.getValue()==3) temp[0] = entryset.getKey();
                else temp[1] = entryset.getKey();
            }
            if(double2) return (temp[0]+temp[1])*(Math.abs(temp[0]-temp[1]));
            else return (int) Math.pow(temp[0]*10+temp[1],2);
                                 
        }else if(map.size()==3){
            
            for(Map.Entry<Integer, Integer> entryset : map.entrySet()){
                if(entryset.getValue()==1){
                    temp[index] = entryset.getKey();
                    index++;
                }
            }
            return temp[0] * temp[1];
            
        }else{
            
            index=Integer.MAX_VALUE;
            for(Map.Entry<Integer, Integer> entryset : map.entrySet()){
                if(index>entryset.getKey()) index = entryset.getKey();
            }
            return index;
        }
    }
}