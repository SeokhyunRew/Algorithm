import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        List<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(char c : my_string.toCharArray()){
            if(c!=' '){
                sb.append(c);
            }else if(c==' ' && sb.length()!=0){
                answer.add(sb.toString());
                sb.setLength(0);
            }else continue;
        }
        
        if(sb.length()!=0) answer.add(sb.toString());
        
        String[] temp = new String[answer.size()];
        
        for(int i=0; i<temp.length; i++) temp[i]=answer.get(i);
        
        return temp;
    }
}