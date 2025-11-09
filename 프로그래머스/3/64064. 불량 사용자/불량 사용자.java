import java.util.*;
class Solution {
    Set<Set<String>> set = new HashSet<>();
    Set<String> visited = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        boolean[] bannedCheck = new boolean[banned_id.length];
        Set<String> userCheck = new HashSet<>();
        
        dfs(0, bannedCheck, userCheck, user_id, banned_id);  
        
        return set.size();
    }
    
    private void dfs(int index, boolean[] bannedCheck, Set<String> userCheck, String[] user_id, String[] banned_id){
        
        if(userCheck.size()==banned_id.length){
            set.add(new HashSet<>(userCheck));
            return;
        }
        
        if(visited.size()==user_id.length) return;
        
        for(int i=index; i<user_id.length; i++){
            String curr = user_id[i];
            if(visited.contains(curr)) continue;
            visited.add(curr);
            for(int j=0; j<banned_id.length; j++){
                if(bannedCheck[j]) continue;
                String target = banned_id[j];
                
                if(candidate(curr, target)){
                    bannedCheck[j]=true;    
                    userCheck.add(curr);
                }
                dfs(i+1, bannedCheck, userCheck, user_id, banned_id);
                if(candidate(curr, target)){
                    bannedCheck[j]=false;
                    userCheck.remove(curr);
                }
            }
            visited.remove(curr);
        }
    }
    
    private boolean candidate(String curr, String target){
        
        if(curr.length()!=target.length()) return false;
        
        for(int i=0; i<target.length(); i++){
            if(target.charAt(i)=='*') continue;
            else if(curr.charAt(i)!=target.charAt(i)) return false;
        }
        
        return true;
    }
}