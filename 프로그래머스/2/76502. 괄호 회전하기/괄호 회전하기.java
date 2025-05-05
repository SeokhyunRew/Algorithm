import java.util.Stack;
class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        
        for(int i=0; i<s.length(); i++){
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            if(check(sb)) answer++;
        }
        
        return answer;
    }
    
    private boolean check(StringBuilder sb){
        Stack<Character> stack = new Stack<>();
        String s = sb.toString();
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

