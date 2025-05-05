import java.util.Stack;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            s=s.substring(1)+s.charAt(0);
            if(check(s)) answer++;
        }
        
        return answer;
    }
    
    private boolean check(String s){
        Stack<Character> stack = new Stack<>();
        char target;
        
        for(char c : s.toCharArray()){
            if(c=='['||c=='{'||c=='(') stack.push(c);
            else if(stack.isEmpty()) return false;
            else{
                target=stack.pop();
                if(c==']'&&target!='[') return false;
                else if(c=='}'&&target!='{') return false;
                if(c==')'&&target!='(') return false;
            }
        }
        
        if(stack.isEmpty()) return true;
        else return false;
    }
    
}

