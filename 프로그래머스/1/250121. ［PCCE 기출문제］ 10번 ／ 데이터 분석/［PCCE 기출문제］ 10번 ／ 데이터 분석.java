import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int target_index=0;
        int sort_index=0;
        int temp_int = 0;
        
        if(ext.equals("code")) target_index=0;
        else if(ext.equals("date")) target_index=1;
        else if(ext.equals("maximum")) target_index=2;
        else if(ext.equals("remain")) target_index=3;
        
        if(sort_by.equals("code")) sort_index=0;
        else if(sort_by.equals("date")) sort_index=1;
        else if(sort_by.equals("maximum")) sort_index=2;
        else if(sort_by.equals("remain")) sort_index=3;
        
        
        for(int i=0; i<data.length; i++){
            if(data[i][target_index]<val_ext) temp_int++;
        }
        
        int[][] answer = new int[temp_int][4];
        int[] sort_arr = new int[temp_int];
        
        HashMap<Integer, int[]> map = new HashMap<>();
        int count =0;
        
        for(int i=0; i<data.length; i++){
            if(data[i][target_index]<val_ext){
                map.put(data[i][sort_index], data[i]);
                sort_arr[count] = data[i][sort_index];
                count++;
            }
        }
        
        Arrays.sort(sort_arr);
        
        for(int i=0; i<temp_int; i++){
            answer[i] = map.get(sort_arr[i]);
        }
            
        return answer;
    }
}