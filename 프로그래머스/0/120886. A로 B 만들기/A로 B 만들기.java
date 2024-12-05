class Solution {
    public int solution(String before, String after) {
        for(String str : after.split("")){
            if(before.contains(str)){
                before = before.replaceFirst(str, "");
                after = after.replaceFirst(str, "");
            }
        }
        
        if(before.isEmpty()&&after.isEmpty()) return 1;
        else return 0;
    }
}