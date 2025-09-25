import java.util.*;
class Solution {
    Stack<String> stack = new Stack<>();
    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        
        stack.push("ICN");
        
        for(int i=0; i<tickets.length; i++){
            String[] str = tickets[i];
            if(str[0].equals("ICN")){
                stack.push(str[1]);
                visited[i]=true;
                dfs(str[1], tickets, visited);
            }
            
            if(stack.size()==tickets.length+1) break;
            
            if(stack.size() > 1) {  // "ICN"은 항상 남겨둠
                stack.pop();
            }
            visited[i]=false;
        }
        
        String[] answer = new String[tickets.length+1];
        
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        
        return answer;
    }
    
    private void dfs(String curr, String[][]tickets, boolean[] visited){
        if(stack.size()==tickets.length+1) return;
        
        for(int i=0; i<tickets.length; i++){
            String[] next = tickets[i];
            if(!visited[i] && next[0].equals(curr)){
                stack.push(next[1]);
                visited[i]=true;
                dfs(next[1], tickets, visited);
                visited[i]=false;
                if(stack.size()!=tickets.length+1) stack.pop();
            }
        }
    }
    
}