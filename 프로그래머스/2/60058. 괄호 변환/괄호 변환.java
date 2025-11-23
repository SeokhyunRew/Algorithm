import java.util.*;
class Solution {
    public String solution(String p) {
        return recursive(p);
    }
    
    private String recursive(String p){
        if(p.length()==0) return "";
        
        int[] temp = new int[2];
        StringBuilder sbU = new StringBuilder();    
        StringBuilder sbV = new StringBuilder();
        boolean isU = true;
        
        for(char c : p.toCharArray()){
            if(isU){
                sbU.append(c);
                if(c=='(') temp[0]++;
                else temp[1]++;
                if(temp[0]==temp[1]) isU=false;
            }else sbV.append(c);
        }
        
        String u = sbU.toString();
        String v = sbV.toString();
        
        if(isRight(u)) return u+recursive(v);
        else{
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(recursive(v));
            sb.append(')');
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') sb.append(')'); 
                else sb.append('(');
            }
            return sb.toString();
        }
    }
    
    private boolean isRight(String p){
        Stack<Character> stack = new Stack<>();
        
        for(char c : p.toCharArray()){
            if(c=='(') stack.push('(');
            else{
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        
        if(stack.isEmpty()) return true;
        else return false;
    }
}