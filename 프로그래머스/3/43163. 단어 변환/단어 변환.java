import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String[]> queue = new LinkedList<>();
        
        queue.add(new String[] {begin, "", "0"});
        
        while(!queue.isEmpty()){
            String[] str = queue.poll();
            String curr = str[0];
            String visited = str[1];
            int depth = Integer.valueOf(str[2]);
            
            if(curr.equals(target)) return depth;
            
            for(String word : words){
                if(!visited.contains(word)){
                    if(canChange(curr, word)){
                        queue.add(new String[] {word, visited+","+word, String.valueOf(depth+1)});    
                    }
                }
            }
        }
        
        return 0;
    }
    
    private boolean canChange(String curr, String word){
        int num = 0;
        for(int i=0; i<curr.length(); i++){
            if(curr.charAt(i)!=word.charAt(i)) num++;
        }
        
        return (num==1);
    }
}