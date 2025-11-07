import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<withIndex> list = new ArrayList<>();
        
        for(int i=0; i<files.length; i++) list.add(new withIndex(i, files[i]));
        
        Collections.sort(list, (a,b) ->{
            int aIndex = a.index;
            int bIndex = b.index;
            String aStr = a.str.toLowerCase();
            String bStr = b.str.toLowerCase();
            String aHead = "";
            String bHead = "";
            int aNumber = 0;
            int bNumber = 0;
            
            for(int i=0; i<aStr.length(); i++){
                if(Character.isDigit(aStr.charAt(i))){
                    aHead = aStr.substring(0,i);
                    aNumber = findNumber(aStr.substring(i));
                    break;
                }
            }
            
            for(int i=0; i<bStr.length(); i++){
                if(Character.isDigit(bStr.charAt(i))){
                    bHead = bStr.substring(0,i);
                    bNumber = findNumber(bStr.substring(i));
                    break;
                }
            }
         
            if(!aHead.equals(bHead)) return aHead.compareTo(bHead);
            else if(aNumber!=bNumber) return aNumber-bNumber;
            else return aIndex-bIndex;
        });
            
        for(int i=0; i<list.size(); i++) answer[i]=list.get(i).str;
        
        return answer;
    }
    
    class withIndex{
        int index;
        String str;
        
        withIndex(int index, String str){
            this.index = index;
            this.str = str;
        }
    }
    
    private int findNumber(String str){
        for(int i=0; i<str.length(); i++){
            if(!Character.isDigit(str.charAt(i))) return Integer.valueOf(str.substring(0,i));
        }
        return Integer.valueOf(str);
    }
    
}