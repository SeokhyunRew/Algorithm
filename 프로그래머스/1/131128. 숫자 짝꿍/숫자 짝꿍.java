import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        boolean temp_b = false;
        String temp_str;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        
        int temp_x = 0;
        int temp_y = 0;
        
        for(int i=9; i>=0; i--){
            temp_x = X.length();
            X = X.replaceAll(String.valueOf(i), "");
            temp_x -= X.length();
            
            temp_y = Y.length();
            Y = Y.replaceAll(String.valueOf(i), "");
            temp_y -= Y.length();
            
            if(temp_x==0||temp_y==0) continue;
            else if(temp_x<=temp_y) for(int j=0; j<temp_x; j++) pq.add(i);
            else for(int j=0; j<temp_y; j++) pq.add(i);
            
            temp_b = true;
        }
        
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        
        String answer = sb.reverse().toString();
        
        return (temp_b==false)?"-1":(answer.charAt(0)=='0')?"0":answer;
    }
}