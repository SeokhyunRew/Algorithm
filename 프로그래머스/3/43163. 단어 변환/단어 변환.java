import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<Word> queue = new LinkedList<>();
        
        queue.offer(new Word(begin, 0));
        
        while(!queue.isEmpty()){
            
            Word word = queue.poll();
            String curr = word.str;
            int depth = word.depth;
            
            if(curr.equals(target)) return depth;
            
            for(int i=0; i<words.length; i++){
                if(visited[i] || !canChange(words[i], curr)) continue;
                queue.offer(new Word(words[i], depth+1));
                visited[i]=true;
            }
            
        }
        
        return 0;
    }
    
    private boolean canChange(String s1, String s2){
        char[] arrC1 = s1.toCharArray();
        char[] arrC2 = s2.toCharArray();
        int temp = 0;
        
        for(int i=0; i<arrC1.length; i++){
            if(arrC1[i]!=arrC2[i]) temp++;
        }
        
        return (temp==1)?true:false;
        
        }
    
    private class Word{
        String str;
        int depth;
        
        public Word(String str, int depth){
            this.str = str;
            this.depth = depth;
        }
        
    }
}