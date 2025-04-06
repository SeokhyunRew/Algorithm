class Solution {
    public String solution(String new_id) {
        String error = "~!@#$%^&*()=+[{]}:?,<>/";
        
        new_id = new_id.toLowerCase();
        
        StringBuilder sb1 = new StringBuilder();   
        
        for(char c : new_id.toCharArray()){
            if(error.contains(String.valueOf(c)))continue;
            else sb1.append(c);
        }
        
        StringBuilder sb2 = new StringBuilder();
        boolean lastDot = false;
        
        for(int i=0; i<sb1.length(); i++){
            if(sb1.charAt(i)=='.'){
                if(!lastDot){
                    sb2.append(sb1.charAt(i));
                    lastDot = true;
                }
            }else{
                sb2.append(sb1.charAt(i));
                lastDot = false;
            }
        }
        
        if(sb2.length() > 0 && sb2.charAt(0)=='.') sb2.deleteCharAt(0);
        if(sb2.length() > 0 && sb2.charAt(sb2.length()-1)=='.') sb2.deleteCharAt(sb2.length()-1);
        if(sb2.length()==0) sb2.append('a');
        if(sb2.length()>15){
            sb2.delete(15, sb2.length());
            if(sb2.charAt(14)=='.') sb2.deleteCharAt(14);
        }
        if(sb2.length()<3){
            while(sb2.length()<3){
                sb2.append(sb2.charAt(sb2.length()-1));
            }
        }
        
        
        return sb2.toString();
    }
}